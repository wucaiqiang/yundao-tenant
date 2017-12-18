

package com.yundao.tenant.dto.report.declaration;

import java.util.List;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年10月31日 下午4:45:14 
 * @author   欧阳利
 * @version   
 */
public class IndexDto {
	
    private List<ReportDto> reportDtos;
    
    private List<IndexTopDto> indexTopDtos;

	public List<ReportDto> getReportDtos() {
	
		return reportDtos;
	}

	public void setReportDtos(List<ReportDto> reportDtos) {
	
		this.reportDtos = reportDtos;
	}

	public List<IndexTopDto> getIndexTopDtos() {
	
		return indexTopDtos;
	}

	public void setIndexTopDtos(List<IndexTopDto> indexTopDtos) {
	
		this.indexTopDtos = indexTopDtos;
	}
    
}

