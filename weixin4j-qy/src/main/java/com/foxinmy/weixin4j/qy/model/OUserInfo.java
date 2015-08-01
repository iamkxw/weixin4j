package com.foxinmy.weixin4j.qy.model;

import java.io.Serializable;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.foxinmy.weixin4j.qy.type.AgentAuthType;

/**
 * 企业号oauth授权登陆信息&第三方应用授权信息
 * 
 * @className OUserInfo
 * @author jy
 * @date 2015年6月12日
 * @since JDK 1.7
 * @see
 */
public class OUserInfo implements Serializable {

	private static final long serialVersionUID = -567063562050171293L;
	/**
	 * 是否系统管理员
	 */
	@JSONField(name = "is_sys")
	private boolean isSysAdmin;
	/**
	 * 是否内部管理员
	 */
	@JSONField(name = "is_inner")
	private boolean isInnerAdmin;
	/**
	 * 登陆管理员信息
	 */
	@JSONField(name = "user_info")
	private User adminInfo;
	/**
	 * 授权方企业信息
	 */
	@JSONField(name = "corp_info")
	private Corpinfo corpinfo;
	/**
	 * 该管理员在该提供商中能使用的应用列表
	 */
	@JSONField(name = "agent")
	private List<AgentItem> agentInfo;
	/**
	 * 该管理员拥有的通讯录权限
	 */
	@JSONField(name = "auth_info")
	private AuthInfo authInfo;

	public boolean isSysAdmin() {
		return isSysAdmin;
	}

	public void setSysAdmin(boolean isSysAdmin) {
		this.isSysAdmin = isSysAdmin;
	}

	public boolean isInnerAdmin() {
		return isInnerAdmin;
	}

	public void setInnerAdmin(boolean isInnerAdmin) {
		this.isInnerAdmin = isInnerAdmin;
	}

	public User getAdminInfo() {
		return adminInfo;
	}

	public void setAdminInfo(User adminInfo) {
		this.adminInfo = adminInfo;
	}

	public Corpinfo getCorpinfo() {
		return corpinfo;
	}

	public void setCorpinfo(Corpinfo corpinfo) {
		this.corpinfo = corpinfo;
	}

	public List<AgentItem> getAgentInfo() {
		return agentInfo;
	}

	public void setAgentInfo(List<AgentItem> agentInfo) {
		this.agentInfo = agentInfo;
	}

	public AuthInfo getAuthInfo() {
		return authInfo;
	}

	public void setAuthInfo(AuthInfo authInfo) {
		this.authInfo = authInfo;
	}

	@Override
	public String toString() {
		return "OUserInfo [isSysAdmin=" + isSysAdmin + ", isInnerAdmin="
				+ isInnerAdmin + ", adminInfo=" + adminInfo + ", corpinfo="
				+ corpinfo + ", agentInfo=" + agentInfo + ", authInfo="
				+ authInfo + "]";
	}

	/**
	 * 授权信息
	 * 
	 * @className AuthInfo
	 * @author jy
	 * @date 2015年6月22日
	 * @since JDK 1.7
	 * @see
	 */
	public static class AuthInfo implements Serializable {

		private static final long serialVersionUID = -4290240764958942370L;
		/**
		 * 授权的应用信息
		 */
		@JSONField(name = "agent")
		private List<AgentItem> agentItems;
		/**
		 * 授权的通讯录部门
		 */
		@JSONField(name = "department")
		private List<DepartmentItem> departmentItems;

		public List<AgentItem> getAgentItems() {
			return agentItems;
		}

		public void setAgentItems(List<AgentItem> agentItems) {
			this.agentItems = agentItems;
		}

		public List<DepartmentItem> getDepartmentItems() {
			return departmentItems;
		}

		public void setDepartmentItems(List<DepartmentItem> departmentItems) {
			this.departmentItems = departmentItems;
		}

		@Override
		public String toString() {
			return "AuthInfo [agentItems=" + agentItems + ", departmentItems="
					+ departmentItems + "]";
		}
	}

	/**
	 * 授权的应用信息
	 * 
	 * @className AgentItem
	 * @author jy
	 * @date 2015年6月22日
	 * @since JDK 1.7
	 * @see
	 */
	public static class AgentItem extends AgentOverview {

		private static final long serialVersionUID = -1188968391623633559L;
		/**
		 * 管理员对应用的权限
		 */
		@JSONField(name = "auth_type")
		private AgentAuthType authType;
		/**
		 * 服务商套件中的对应应用id
		 */
		private int appid;
		/**
		 * 授权方应用敏感权限组，目前仅有get_location，表示是否有权限设置应用获取地理位置的开关
		 */
		@JSONField(name = "api_group")
		private List<String> apiGroup;

		public AgentAuthType getAuthType() {
			return authType;
		}

		public void setAuthType(int authType) {
			if (authType == 0) {
				this.authType = AgentAuthType.USE;
			} else if (authType == 1) {
				this.authType = AgentAuthType.MANAGE;
			}
			this.authType = null;
		}

		public int getAppid() {
			return appid;
		}

		public void setAppid(int appid) {
			this.appid = appid;
		}

		public List<String> getApiGroup() {
			return apiGroup;
		}

		public void setApiGroup(List<String> apiGroup) {
			this.apiGroup = apiGroup;
		}

		@Override
		public String toString() {
			return "AgentItem [authType=" + authType + ", appid=" + appid
					+ ", apiGroup=" + apiGroup + ", " + super.toString() + "]";
		}
	}

	/**
	 * 授权的通讯录部门
	 * 
	 * @className DepartmentItem
	 * @author jy
	 * @date 2015年6月22日
	 * @since JDK 1.7
	 * @see
	 */
	public static class DepartmentItem extends Party {

		private static final long serialVersionUID = 556556672204642407L;

		/**
		 * 是否具有该部门的写权限
		 */
		private boolean writable;

		public boolean isWritable() {
			return writable;
		}

		public void setWritable(boolean writable) {
			this.writable = writable;
		}

		@Override
		public String toString() {
			return "DepartmentItem [writable=" + writable + ", "
					+ super.toString() + "]";
		}
	}
}
