package models;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


@XmlType(name="ResComponent")
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
	
	
	
	
}
