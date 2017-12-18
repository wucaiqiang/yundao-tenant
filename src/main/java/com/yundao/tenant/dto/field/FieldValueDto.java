package com.yundao.tenant.dto.field;

public class FieldValueDto {
	
    private Long objectFieldId;
    
    private Long referenceTableId;
    
    private String value;
    
    private Integer slot;

	public Long getObjectFieldId() {
		return objectFieldId;
	}

	public void setObjectFieldId(Long objectFieldId) {
		this.objectFieldId = objectFieldId;
	}

	public Long getReferenceTableId() {
		return referenceTableId;
	}

	public void setReferenceTableId(Long referenceTableId) {
		this.referenceTableId = referenceTableId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getSlot() {
		return slot;
	}

	public void setSlot(Integer slot) {
		this.slot = slot;
	}

    
}
