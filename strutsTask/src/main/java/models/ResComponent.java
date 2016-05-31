package models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


@XmlType(name="ResComponent")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResComponent {
	@XmlAttribute(name = "ComponentTypeCode")
	private String componentTypeCode;
	@XmlAttribute(name = "CreateDateTime")
	private String createDateTime;
	@XmlAttribute(name = "InternalStatus")
	private String internalStatus;
	

	
	
	public ResComponent() {
	}

	public ResComponent(String componentTypeCode, String createDateTime, String internalStatus) {
		this.componentTypeCode = componentTypeCode;
		this.createDateTime = createDateTime;
		this.internalStatus = internalStatus;
	}

	@Override
	public String toString() {
		return "\n[componentTypeCode=" + componentTypeCode + ", createDateTime=" + createDateTime
				+ ", internalStatus=" + internalStatus + "]";
	}

	public String getComponentTypeCode() {
		return componentTypeCode;
	}

	public void setComponentTypeCode(String componentTypeCode) {
		this.componentTypeCode = componentTypeCode;
	}

	public String getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(String createDateTime) {
		this.createDateTime = createDateTime;
	}

	public String getInternalStatus() {
		return internalStatus;
	}

	public void setInternalStatus(String internalStatus) {
		this.internalStatus = internalStatus;
	}
	
	
	
	
}
