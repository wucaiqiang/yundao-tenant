package com.yundao.tenant.dto.workflow;

public class GroupUserReqDto {

    /**
     * 资源id
     */
    private Long userId;

    /**
     * 编码
     */
    private String groupId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}


}
