package com.yundao.tenant.service.field.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.esotericsoftware.minlog.Log;
import com.yundao.core.exception.BaseException;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.DateUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.core.utils.RegularUtils;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.field.AddressDto;
import com.yundao.tenant.dto.field.DateRangeFieldDto;
import com.yundao.tenant.dto.field.FieldConfigDto;
import com.yundao.tenant.dto.field.FieldDto;
import com.yundao.tenant.dto.field.FieldValueValidateFailResultDto;
import com.yundao.tenant.dto.field.NumberConfigDto;
import com.yundao.tenant.dto.field.SelectConfigDto;
import com.yundao.tenant.enums.bo.FieldTypeEnum;
import com.yundao.tenant.service.field.FieldValueValidateService;
import com.yundao.tenant.util.field.FieldUtils;

@Service
public class FieldValueValidateServiceImpl implements FieldValueValidateService {

    /**
     * 字段校验
     */
	@Override
	public List<FieldValueValidateFailResultDto> validateFieldValue(List<FieldDto> list, Map<String, String> allParams) throws  Exception{
		if(BooleanUtils.isEmpty(list)){
			return null;
		}
		if(BooleanUtils.isEmpty(allParams)){
			throw new BaseException(CodeConstant.CODE_1200034,"请求参数不能为空！");
		}
		// 必填校验
		List<FieldValueValidateFailResultDto> faildList = validateMandatoryValue(list, allParams);
		if(!BooleanUtils.isEmpty(faildList)){
			return faildList;
		}
		// 长度校验
		faildList =validateValueLength(list, allParams);
		if(!BooleanUtils.isEmpty(faildList)){
			return faildList;
		}
		// 日期类型校验
		faildList = validateDateType(list, allParams);
		if(!BooleanUtils.isEmpty(faildList)){
			return faildList;
		}
		// 日期范围类型校验
		faildList = validateDateRangeType(list, allParams);
		if(!BooleanUtils.isEmpty(faildList)){
			return faildList;
		}
		// 下拉选项校验
		faildList = validateSelectType(list, allParams);
		if(!BooleanUtils.isEmpty(faildList)){
			return faildList;
		}
		// 单选校验
		faildList = validateRadioType(list, allParams);
		if(!BooleanUtils.isEmpty(faildList)){
			return faildList;
		}
		// 复选校验
		faildList = validateCheckboxType(list, allParams);
		if(!BooleanUtils.isEmpty(faildList)){
			return faildList;
		}
		// 数字校验
		faildList = validateNumberType(list, allParams);
		if(!BooleanUtils.isEmpty(faildList)){
			return faildList;
		}
		// 数字范围校验
		faildList = validateNumberRangeType(list, allParams);
		if(!BooleanUtils.isEmpty(faildList)){
			return faildList;
		}
		// 校验地址
		faildList = validateAddressType(list, allParams);
		if(!BooleanUtils.isEmpty(faildList)){
			return faildList;
		}
		return faildList;
	}

	/**
	 * 检查字段是否必填
	 * @param list
	 * @param allParams
	 * @return
	 */
	private List<FieldValueValidateFailResultDto> validateMandatoryValue(List<FieldDto> list, Map<String, String> allParams) {
		List<FieldValueValidateFailResultDto> faildList = new ArrayList<FieldValueValidateFailResultDto>();
		for(FieldDto dto:list){
			if(dto.getIsMandatory() == 1 && BooleanUtils.isBlank(allParams.get(dto.getName()))){
				FieldValueValidateFailResultDto faildDto  = new FieldValueValidateFailResultDto();
				faildDto.setLable(dto.getLabel());
				faildDto.setName(dto.getName());
				faildDto.setMessage(dto.getLabel()+"不能为空！");
				faildList.add(faildDto);
			}
		}
		return faildList;
	}
	
	
	/**
	 * 字段长度校验
	 * @param list
	 * @param allParams
	 * @return
	 */
	private List<FieldValueValidateFailResultDto> validateValueLength(List<FieldDto> list, Map<String, String> allParams){
		List<FieldValueValidateFailResultDto> faildList = new ArrayList<FieldValueValidateFailResultDto>();
		for(FieldDto dto:list){
			if(dto.getFieldConfigDto() != null && !BooleanUtils.isBlank(allParams.get(dto.getName()))){
				FieldConfigDto fieldConfigDto = dto.getFieldConfigDto();
				String value = allParams.get(dto.getName());
				boolean isLengthError = false;
				if(FieldTypeEnum.TEXT.getCode().equals(dto.getTypeCode())
						|| FieldTypeEnum.TEXT_AREA.getCode().equals(dto.getTypeCode())
						|| FieldTypeEnum.ADDRESS.getCode().equals(dto.getTypeCode())){
					if(fieldConfigDto.getMaxLength() != null && value.length() > fieldConfigDto.getMaxLength()){
						isLengthError = true;
					}
					if(fieldConfigDto.getMinLength() != null && value.length() < fieldConfigDto.getMinLength()){
						isLengthError = true;
					}
				}
				
				if(isLengthError){
					StringBuffer message = new StringBuffer(dto.getLabel()).append("的长度必须");
					if(fieldConfigDto.getMinLength() != null){
						message.append("大于等于").append(fieldConfigDto.getMinLength());
					}
					if(fieldConfigDto.getMinLength() != null && fieldConfigDto.getMinLength() != null){
						message.append("并且");
					}
					if(fieldConfigDto.getMaxLength() != null){
						message.append("小于等于").append(fieldConfigDto.getMaxLength());
					}
					FieldValueValidateFailResultDto faildDto  = new FieldValueValidateFailResultDto();
					faildDto.setLable(dto.getLabel());
					faildDto.setName(dto.getName());
					faildDto.setMessage(message.toString());
					faildList.add(faildDto);
				}
			}
		}
		return faildList;
	}
	
	
	/**
	 * 检查日期是否正确
	 * @param list
	 * @param allParams
	 * @return
	 */
	private List<FieldValueValidateFailResultDto> validateDateType(List<FieldDto> list, Map<String, String> allParams)throws Exception{
		List<FieldValueValidateFailResultDto> faildList = new ArrayList<FieldValueValidateFailResultDto>();
		for(FieldDto dto:list){
			if(FieldTypeEnum.DATE.getCode().equals(dto.getTypeCode()) && !BooleanUtils.isBlank(allParams.get(dto.getName()))){
				String date = allParams.get(dto.getName());
				if(date.trim().length() != 10){
					FieldValueValidateFailResultDto faildDto  = new FieldValueValidateFailResultDto();
					faildDto.setLable(dto.getLabel());
					faildDto.setName(dto.getName());
					faildDto.setMessage(dto.getLabel()+"日期格式不正确！格式：yyyy-MM-dd");
					faildList.add(faildDto);
					continue;
				}
				
				Boolean result = DateUtils.isValidDate(date, DateUtils.YYYY_MM_DD);
				if(!result){
					FieldValueValidateFailResultDto faildDto  = new FieldValueValidateFailResultDto();
					faildDto.setLable(dto.getLabel());
					faildDto.setName(dto.getName());
					faildDto.setMessage(dto.getLabel()+"日期格式不正确！格式：yyyy-MM-dd");
					faildList.add(faildDto);
					 continue;
				}
				
				if(result){
					// 检查日期是否合法
					List<FieldValueValidateFailResultDto> monthAndDayDtos =  validateDateMonthAndDay(dto,date);
					if(!BooleanUtils.isEmpty(monthAndDayDtos)){
				        faildList.addAll(monthAndDayDtos);
				        continue;
				    }
					
		        	// 日期最大值和最小值校验
		        	List<FieldValueValidateFailResultDto> dtos = validateDateMaxAndMin(dto,date, dto.getFieldConfigDto());
			        if(!BooleanUtils.isEmpty(dtos)){
			        	faildList.addAll(dtos);
			        	continue;
			        }
		        }
			}
		}
		return faildList;
	}
	
	/**
	 * 检查日期范围是否正确
	 * @param list
	 * @param allParams
	 * @return
	 */
	private List<FieldValueValidateFailResultDto> validateDateRangeType(List<FieldDto> list, Map<String, String> allParams)throws Exception{
		List<FieldValueValidateFailResultDto> faildList = new ArrayList<FieldValueValidateFailResultDto>();
		for(FieldDto dto:list){
			if(FieldTypeEnum.DATE_RANGE.getCode().equals(dto.getTypeCode()) && !BooleanUtils.isBlank(allParams.get(dto.getName()))){
				String dateRange = allParams.get(dto.getName());
				// 日期格式校验
				boolean dateFormatError = false;
                String[] dateRanges = dateRange.split(FieldUtils.SPLIT_SYMBOL);
                for(String date : dateRanges){
                	if(!BooleanUtils.isBlank(date)){
                		Boolean result = DateUtils.isValidDate(date, DateUtils.YYYY_MM_DD);
        				if(!result){
        					FieldValueValidateFailResultDto faildDto  = new FieldValueValidateFailResultDto();
        					faildDto.setLable(dto.getLabel());
        					faildDto.setName(dto.getName());
        					faildDto.setMessage(dto.getLabel()+"日期格式不正确！格式：yyyy-MM-dd");
        					faildList.add(faildDto);
        					dateFormatError = true;
        					break;
        				}
        				
        				if(result){
        		        	// 日期最大值和最小值校验
        		        	List<FieldValueValidateFailResultDto> dtos = validateDateMaxAndMin(dto,date, dto.getFieldConfigDto());
        			        if(!BooleanUtils.isEmpty(dtos)){
        			        	faildList.addAll(dtos);
        			        	break;
        			        }
        		        }
                	}
                }
                
                if(dateFormatError){
                	continue;
                }
                
				// 校验是否空
				DateRangeFieldDto dateRangeFieldDto = FieldUtils.getDateRangeField(dateRange);
				if(dto.getIsMandatory() == 1 && (dateRangeFieldDto.getStartDate() == null || dateRangeFieldDto.getEndDate() == null)){
					FieldValueValidateFailResultDto faildDto  = new FieldValueValidateFailResultDto();
					faildDto.setLable(dto.getLabel());
					faildDto.setName(dto.getName());
					faildDto.setMessage(dto.getLabel()+"不能为空！");
					faildList.add(faildDto);
					continue;
				}
				
				
				// 检查结束日期是否大于等于开始日期
				List<FieldValueValidateFailResultDto> validateResults =validateDateRangeStartAndEnd(dto,dateRangeFieldDto);
				if(!BooleanUtils.isEmpty(validateResults)){
					faildList.addAll(validateResults);
					continue;
				}
				
			}
		}	
		return faildList;
	}
	
	/**
	 * 检查下拉选择是否正确
	 * @param list
	 * @param allParams
	 * @return
	 */
	private List<FieldValueValidateFailResultDto> validateSelectType(List<FieldDto> list, Map<String, String> allParams){
		List<FieldValueValidateFailResultDto> faildList = new ArrayList<FieldValueValidateFailResultDto>();
		for(FieldDto dto:list){
			if(FieldTypeEnum.SELECT.getCode().equals(dto.getTypeCode()) && !BooleanUtils.isBlank(allParams.get(dto.getName()))){
				List<SelectConfigDto> selectDtos = dto.getSelectDtos();
				String value = allParams.get(dto.getName());
				boolean isQuqal = false;
				if(!BooleanUtils.isEmpty(selectDtos)){
					for(SelectConfigDto selectDto : selectDtos){
						if(selectDto.getValue().toString().equals(value)){
							isQuqal = true;
							continue;
						}
					}
				}
				if(!isQuqal){
					FieldValueValidateFailResultDto faildDto  = new FieldValueValidateFailResultDto();
					faildDto.setLable(dto.getLabel());
					faildDto.setName(dto.getName());
					faildDto.setMessage(dto.getLabel()+"选项值不正确！");
					faildList.add(faildDto);
				}
			}
		}
		return faildList;
	}
	
	/**
	 * 检查单选是否正确
	 * @param list
	 * @param allParams
	 * @return
	 */
	private List<FieldValueValidateFailResultDto> validateRadioType(List<FieldDto> list, Map<String, String> allParams){
		List<FieldValueValidateFailResultDto> faildList = new ArrayList<FieldValueValidateFailResultDto>();
		for(FieldDto dto:list){
			if(FieldTypeEnum.RADIO.getCode().equals(dto.getTypeCode()) && !BooleanUtils.isBlank(allParams.get(dto.getName()))){
				List<SelectConfigDto> selectDtos = dto.getSelectDtos();
				String value = allParams.get(dto.getName());
				boolean isQuqal = false;
				if(!BooleanUtils.isEmpty(selectDtos)){
					for(SelectConfigDto selectDto : selectDtos){
						if(selectDto.getValue().toString().equals(value)){
							isQuqal = true;
						}
					}
				}
				if(!isQuqal){
					FieldValueValidateFailResultDto faildDto  = new FieldValueValidateFailResultDto();
					faildDto.setLable(dto.getLabel());
					faildDto.setName(dto.getName());
					faildDto.setMessage(dto.getLabel()+"选项值不正确！");
					faildList.add(faildDto);
				}
			}
		}
		return faildList;
	}
	
	/**
	 * 检查复选是否正确
	 * @param list
	 * @param allParams
	 * @return
	 */
	private List<FieldValueValidateFailResultDto> validateCheckboxType(List<FieldDto> list, Map<String, String> allParams){
		List<FieldValueValidateFailResultDto> faildList = new ArrayList<FieldValueValidateFailResultDto>();
		for(FieldDto dto:list){
			if(FieldTypeEnum.CHECKBOX.getCode().equals(dto.getTypeCode()) && !BooleanUtils.isBlank(allParams.get(dto.getName()))){
				List<SelectConfigDto> selectDtos = dto.getSelectDtos();
				String value = allParams.get(dto.getName());
				List<String> values = FieldUtils.getCheckBoxField(value);
				if(dto.getIsMandatory() == 1 && BooleanUtils.isEmpty(values)){
					FieldValueValidateFailResultDto faildDto  = new FieldValueValidateFailResultDto();
					faildDto.setLable(dto.getLabel());
					faildDto.setName(dto.getName());
					faildDto.setMessage(dto.getLabel()+"不能为空！");
					faildList.add(faildDto);
					continue;
				}
				
                for(String v : values){
    				boolean isQuqal = false;
    				if(!BooleanUtils.isEmpty(selectDtos)){
    					for(SelectConfigDto selectDto : selectDtos){
    						if(selectDto.getValue().toString().equals(v)){
    							isQuqal = true;
    						}
    					}
    				}
    				if(!isQuqal){
    					FieldValueValidateFailResultDto faildDto  = new FieldValueValidateFailResultDto();
    					faildDto.setLable(dto.getLabel());
    					faildDto.setName(dto.getName());
    					faildDto.setMessage(dto.getLabel()+"选项值不正确！");
    					faildList.add(faildDto);
    					break;
    				}
				}
			}
		}
		return faildList;
	}
	
	/**
	 * 检查数字是否正确
	 * @param list
	 * @param allParams
	 * @return
	 */
	private List<FieldValueValidateFailResultDto> validateNumberType(List<FieldDto> list, Map<String, String> allParams){
		List<FieldValueValidateFailResultDto> faildList = new ArrayList<FieldValueValidateFailResultDto>();
		for(FieldDto dto:list){
			if(FieldTypeEnum.NUMBER.getCode().equals(dto.getTypeCode()) && !BooleanUtils.isBlank(allParams.get(dto.getName()))){
				Pattern p = Pattern.compile(RegularUtils.Regular.DOUBLE);  
		        Matcher m = p.matcher(allParams.get(dto.getName()));  
		        boolean isMatch = m.matches();  
		        if(!isMatch){
		        	FieldValueValidateFailResultDto faildDto  = new FieldValueValidateFailResultDto();
					faildDto.setLable(dto.getLabel());
					faildDto.setName(dto.getName());
					faildDto.setMessage(dto.getLabel()+"输入的不是数字！");
					faildList.add(faildDto);
		        }
		       
		        if(isMatch){
		        	// 数字校验
		        	List<FieldValueValidateFailResultDto> dtos = validateNumberMaxAndMin(dto,allParams.get(dto.getName()), dto.getFieldConfigDto());
			        if(!BooleanUtils.isEmpty(dtos)){
			        	faildList.addAll(dtos);
			        }
		        }
		        
			}
		}
		return faildList;
	}
	
	/**
	 * 检查数字范围是否正确
	 * @param list
	 * @param allParams
	 * @return
	 */
	private List<FieldValueValidateFailResultDto> validateNumberRangeType(List<FieldDto> list, Map<String, String> allParams){
		List<FieldValueValidateFailResultDto> faildList = new ArrayList<FieldValueValidateFailResultDto>();
		for(FieldDto dto:list){
			if(FieldTypeEnum.NUMBER.getCode().equals(dto.getTypeCode()) && !BooleanUtils.isBlank(allParams.get(dto.getName()))){
				List<String> numberRanges = FieldUtils.getNumberRangeField(allParams.get(dto.getName()));
				if(dto.getIsMandatory() == 1 && BooleanUtils.isEmpty(numberRanges)){
					FieldValueValidateFailResultDto faildDto  = new FieldValueValidateFailResultDto();
					faildDto.setLable(dto.getLabel());
					faildDto.setName(dto.getName());
					faildDto.setMessage(dto.getLabel()+"不能为空！");
					faildList.add(faildDto);
					continue;
				}
				for(String v :numberRanges){
					Pattern p = Pattern.compile(RegularUtils.Regular.DOUBLE);  
			        Matcher m = p.matcher(v);  
			        boolean isMatch = m.matches();  
			        if(!isMatch){
			        	FieldValueValidateFailResultDto faildDto  = new FieldValueValidateFailResultDto();
						faildDto.setLable(dto.getLabel());
						faildDto.setName(dto.getName());
						faildDto.setMessage(dto.getLabel()+"输入的不是数字!");
						faildList.add(faildDto);
						break;
			        }
			        
			        if(isMatch){
			        	// 数字校验
			        	List<FieldValueValidateFailResultDto> dtos = validateNumberMaxAndMin(dto,v, dto.getFieldConfigDto());
				        if(!BooleanUtils.isEmpty(dtos)){
				        	faildList.addAll(dtos);
				        }
				        // 校验小数点位数
				        List<FieldValueValidateFailResultDto> decimalDtos = validateNumberDecimalLength(dto,v);
				        if(!BooleanUtils.isEmpty(decimalDtos)){
				        	faildList.addAll(decimalDtos);
				        }
			        }
				}
			}
		}
		return faildList;
	}
	
	
	/**
	 * 校验数字最大值和最小值
	 * @param value
	 * @param fieldConfigDto
	 * @return
	 */
	private List<FieldValueValidateFailResultDto>  validateNumberMaxAndMin(FieldDto dto,String value,FieldConfigDto fieldConfigDto){
		if(fieldConfigDto == null || BooleanUtils.isBlank(value)){
			return null;
		}
		List<FieldValueValidateFailResultDto> faildList = new ArrayList<FieldValueValidateFailResultDto>();
		double v = Double.valueOf(value);
		if(fieldConfigDto.getMinValue() != null){
			double min = Double.valueOf(fieldConfigDto.getMinValue());
			if(v < min){
				FieldValueValidateFailResultDto faildDto  = new FieldValueValidateFailResultDto();
				faildDto.setLable(dto.getLabel());
				faildDto.setName(dto.getName());
				faildDto.setMessage(dto.getLabel()+"不能小于"+min);
				faildList.add(faildDto);
			}
		}
		if(fieldConfigDto.getMaxValue() != null){
			double max = Double.valueOf(fieldConfigDto.getMaxValue());
			if(v > max){
				FieldValueValidateFailResultDto faildDto  = new FieldValueValidateFailResultDto();
				faildDto.setLable(dto.getLabel());
				faildDto.setName(dto.getName());
				faildDto.setMessage(dto.getLabel()+"不能大于"+max);
				faildList.add(faildDto);
			}
		}
		return faildList;
	}
	
	
	
	/**
	 * 校验小数点位数
	 * @param dto
	 * @param value
	 * @param fieldConfigDto
	 * @return
	 */
	private List<FieldValueValidateFailResultDto> validateNumberDecimalLength(FieldDto dto,String value){
		NumberConfigDto configDto = dto.getNumberDto();
		if(configDto == null || BooleanUtils.isBlank(value)  || configDto.getDecimalLength() == null){
			return null;
		}
		List<FieldValueValidateFailResultDto> faildList = new ArrayList<FieldValueValidateFailResultDto>();
		
		if(configDto.getDecimalLength() <=0){
			if(value.contains(".")){
				FieldValueValidateFailResultDto faildDto  = new FieldValueValidateFailResultDto();
				faildDto.setLable(dto.getLabel());
				faildDto.setName(dto.getName());
				faildDto.setMessage(dto.getLabel()+"不能输入小数");
				faildList.add(faildDto);
			}
		}else{
			if(value.contains(".")){
				String decimal = value.substring(value.indexOf("."));
				if(configDto.getDecimalLength() < decimal.length()-1){
					FieldValueValidateFailResultDto faildDto  = new FieldValueValidateFailResultDto();
					faildDto.setLable(dto.getLabel());
					faildDto.setName(dto.getName());
					faildDto.setMessage(dto.getLabel()+" 小数点后最多保留"+configDto.getDecimalLength()+"小数");
					faildList.add(faildDto);
				}
			}
		}
		return faildList;
	}
	
	/**
	 * 校验日期是否有效
	 * @param dto
	 * @param value
	 * @param fieldConfigDto
	 * @return
	 * @throws Exception 
	 */
	private List<FieldValueValidateFailResultDto>  validateDateMaxAndMin(FieldDto dto,String value,FieldConfigDto fieldConfigDto) throws Exception{
		if(fieldConfigDto == null || BooleanUtils.isBlank(value) || DateUtils.isValidDate(value, DateUtils.YYYY_MM_DD)){
			return null;
		}
		
		if(fieldConfigDto.getMaxValue() == null && fieldConfigDto.getMinValue() == null){
			return null;
		}
		
		if(DateUtils.isValidDate(value, DateUtils.YYYY_MM_DD)){
			return null;
		}
		Date dateValue = DateUtils.parse(value, DateUtils.YYYY_MM_DD);
		List<FieldValueValidateFailResultDto> faildList = new ArrayList<FieldValueValidateFailResultDto>();
		if(fieldConfigDto.getMaxValue() != null && DateUtils.isValidDate(fieldConfigDto.getMaxValue(), DateUtils.YYYY_MM_DD)){
			Date maxDate = DateUtils.parse(fieldConfigDto.getMaxValue(), DateUtils.YYYY_MM_DD);
			if(dateValue.after(maxDate)){
				FieldValueValidateFailResultDto faildDto  = new FieldValueValidateFailResultDto();
				faildDto.setLable(dto.getLabel());
				faildDto.setName(dto.getName());
				faildDto.setMessage(dto.getLabel()+"不能大于"+fieldConfigDto.getMaxValue());
				faildList.add(faildDto);
			}
		}
		
		if(fieldConfigDto.getMinValue() != null && DateUtils.isValidDate(fieldConfigDto.getMinValue(), DateUtils.YYYY_MM_DD)){
			Date minDate = DateUtils.parse(fieldConfigDto.getMinValue(), DateUtils.YYYY_MM_DD);
            if(dateValue.before(minDate)){
            	FieldValueValidateFailResultDto faildDto  = new FieldValueValidateFailResultDto();
				faildDto.setLable(dto.getLabel());
				faildDto.setName(dto.getName());
				faildDto.setMessage(dto.getLabel()+"不能大于"+fieldConfigDto.getMinValue());
				faildList.add(faildDto);
			}
		}
		return faildList;
		
	}
	
	/**
	 * 校验开始日期是否小于等于结束日期
	 * @param dto
	 * @param value
	 * @param dateRanges
	 * @return
	 */
	private  List<FieldValueValidateFailResultDto> validateDateRangeStartAndEnd(FieldDto dto,DateRangeFieldDto dateRangeFieldDto) throws Exception{
		if(dateRangeFieldDto.getStartDate()  == null || dateRangeFieldDto.getEndDate() == null ){
			return null;
		}
		Date minDate = dateRangeFieldDto.getStartDate() ;
		Date maxDate = dateRangeFieldDto.getEndDate();
		
		List<FieldValueValidateFailResultDto> faildList = new ArrayList<FieldValueValidateFailResultDto>();
		if(minDate.after(maxDate)){
			FieldValueValidateFailResultDto faildDto  = new FieldValueValidateFailResultDto();
			faildDto.setLable(dto.getLabel());
			faildDto.setName(dto.getName());
			faildDto.setMessage(dto.getLabel()+"开始日期不能大于结束日期");
			faildList.add(faildDto);
		}
		return faildList;
	}
	
	
	
	/**
	 * 检查日期是否合法(月份不能大于12, 小于1; 月份不能大于31, 小于1)
	 * @param dto
	 * @param value
	 * @return
	 */
	private List<FieldValueValidateFailResultDto> validateDateMonthAndDay(FieldDto dto,String value){
		if(dto == null || BooleanUtils.isBlank(value)){
			return null;
		}
		String[] date = value.split("-");
		if(BooleanUtils.isEmpty(date) || date.length !=3){
			return null;
		}
		List<FieldValueValidateFailResultDto> faildList = new ArrayList<FieldValueValidateFailResultDto>();
		int year = Integer.valueOf(date[0].trim());
		int month = Integer.valueOf(date[1].trim());
		int day = Integer.valueOf(date[2].trim());
		if(year<1970){
			FieldValueValidateFailResultDto faildDto  = new FieldValueValidateFailResultDto();
			faildDto.setLable(dto.getLabel());
			faildDto.setName(dto.getName());
			faildDto.setMessage(dto.getLabel()+"中年份不对");
			faildList.add(faildDto);
		}
		if(month>12 || day<1){
			FieldValueValidateFailResultDto faildDto  = new FieldValueValidateFailResultDto();
			faildDto.setLable(dto.getLabel());
			faildDto.setName(dto.getName());
			faildDto.setMessage(dto.getLabel()+"中月份不对");
			faildList.add(faildDto);
		}
		int maxDay = getMonthMaxDay(year,month);
		if(day<1 || day>maxDay){
			FieldValueValidateFailResultDto faildDto  = new FieldValueValidateFailResultDto();
			faildDto.setLable(dto.getLabel());
			faildDto.setName(dto.getName());
			faildDto.setMessage(dto.getLabel()+"中天数不对");
			faildList.add(faildDto);
		}
		return faildList;
	}
	
	
	/**
	 * 获取月份的最大天数
	 * @param y
	 * @param n
	 * @return
	 */
	private  int getMonthMaxDay(int y,int n) {
		int day = 0;
        switch (n) {
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
            day = 31;
            break;
            //对于2月份需要判断是否为闰年
        case 2:
            if ((y % 4 == 0 && y % 100 != 0) || (y % 400 == 0)) {
                day = 29;
                break;
            } else {
                day = 28;
                break;
            }
        case 4:
        case 6:
        case 9:
        case 11:
            day = 30;
            break;
        default:
            break;
        }
        return day;
    }
	
	/**
	 * 地址校验
	 * @param list
	 * @param allParams
	 * @return
	 */
	private List<FieldValueValidateFailResultDto> validateAddressType(List<FieldDto> list, Map<String, String> allParams){
		List<FieldValueValidateFailResultDto> faildList = new ArrayList<FieldValueValidateFailResultDto>();
		if(!BooleanUtils.isEmpty(list)){
			for(FieldDto dto:list){
				if(FieldTypeEnum.ADDRESS.getCode().equals(dto.getTypeCode()) && !BooleanUtils.isBlank(allParams.get(dto.getName()))){
					String address = allParams.get(dto.getName());
					// 校验格式
					AddressDto addressDto = null;
					try{
						addressDto = JsonUtils.jsonToObject(address, AddressDto.class);
					}catch(Exception e){
						FieldValueValidateFailResultDto faildDto  = new FieldValueValidateFailResultDto();
						faildDto.setLable(dto.getLabel());
						faildDto.setName(dto.getName());
						faildDto.setMessage(dto.getLabel()+"数据格式不对");
						faildList.add(faildDto);
						continue;
					}
					
					
					// 校验必填
					if(dto.getIsMandatory() == 1 && addressDto == null){
						FieldValueValidateFailResultDto faildDto  = new FieldValueValidateFailResultDto();
						faildDto.setLable(dto.getLabel());
						faildDto.setName(dto.getName());
						faildDto.setMessage(dto.getLabel()+"不能为空！");
						faildList.add(faildDto);
						continue;
					}
					if(dto.getIsMandatory() == 1  && BooleanUtils.isEmpty(addressDto.getProvince())
							 && BooleanUtils.isEmpty(addressDto.getCity())
							 && BooleanUtils.isEmpty(addressDto.getAddress())){
						FieldValueValidateFailResultDto faildDto  = new FieldValueValidateFailResultDto();
						faildDto.setLable(dto.getLabel());
						faildDto.setName(dto.getName());
						faildDto.setMessage(dto.getLabel()+"不能为空！");
						faildList.add(faildDto);
						continue;
					}
				}
			}
		}
		return faildList;
	}
}
