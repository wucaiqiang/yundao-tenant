

package com.yundao.tenant.dto.sale.declaration;

import java.util.List;

import com.yundao.core.utils.BooleanUtils;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月6日 上午11:05:04 
 * @author   欧阳利
 * @version   
 */
public class DeclarationUserDto {
    private Long id;
    
    private String name;

	public DeclarationUserDto(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
	
		return id;
	}

	public void setId(Long id) {
	
		this.id = id;
	}

	public String getName() {
	
		return name;
	}

	public void setName(String name) {
	
		this.name = name;
	}

	public static boolean contains(List<DeclarationUserDto> userDtos, Long id){
		if(!BooleanUtils.isEmpty(userDtos)){
			return false;
		}
		for(DeclarationUserDto dto: userDtos){
			if(dto.getId().equals(id)){
				return true;
			}
		}
		return false;
	}
    
}

