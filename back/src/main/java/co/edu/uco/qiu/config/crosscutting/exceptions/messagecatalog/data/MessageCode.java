package co.edu.uco.qiu.config.crosscutting.exceptions.messagecatalog.data;

import co.edu.uco.qiu.config.crosscutting.helpers.StringTool;
import static co.edu.uco.qiu.config.crosscutting.helpers.StringTool.UNDERSCORE;

public enum MessageCode {
	
	M00001(MessageCategory.ERROR, MessageType.TECHNICAL, "00001", true),
	M00002(MessageCategory.ERROR, MessageType.BUSSINESS, "00002", true),
	M00003(MessageCategory.ERROR, MessageType.TECHNICAL, "00003", true),
	M00004(MessageCategory.ERROR, MessageType.TECHNICAL, "00004", true),
	M00005(MessageCategory.ERROR, MessageType.TECHNICAL, "00005", true),
	M00006(MessageCategory.ERROR, MessageType.TECHNICAL, "00006", true),
	
	
	//M00007(MessageCategory.SUCCESS, MessageType.BUSSINESS, "00007", false), // External
	//M00008(MessageCategory.SUCCESS, MessageType.BUSSINESS, "00008", false),
	
	M00007(MessageCategory.ERROR, MessageType.TECHNICAL, "00007", true),
	M00008(MessageCategory.ERROR, MessageType.TECHNICAL, "00008", true),
	
	M00010(MessageCategory.ERROR, MessageType.TECHNICAL, "00010", false),
	M00009(MessageCategory.ERROR, MessageType.TECHNICAL, "00009", true),
	M00011(MessageCategory.ERROR, MessageType.TECHNICAL, "00011", true),
	M00012(MessageCategory.ERROR, MessageType.TECHNICAL, "00012", true),
	M00013(MessageCategory.ERROR, MessageType.TECHNICAL, "00013", true),
	M00014(MessageCategory.ERROR, MessageType.TECHNICAL, "00014", true),
	M00015(MessageCategory.ERROR, MessageType.TECHNICAL, "00015", true),
	M00016(MessageCategory.ERROR, MessageType.TECHNICAL, "00016", true),
	M00017(MessageCategory.ERROR, MessageType.TECHNICAL, "00017", true),
	M00018(MessageCategory.ERROR, MessageType.TECHNICAL, "00018", true),
	M00019(MessageCategory.ERROR, MessageType.TECHNICAL, "00019", true),
	M00020(MessageCategory.ERROR, MessageType.TECHNICAL, "00020", true),
	M00021(MessageCategory.ERROR, MessageType.TECHNICAL, "00021", true),
	M00022(MessageCategory.ERROR, MessageType.TECHNICAL, "00022", true);
	
	private MessageCode(MessageCategory category, MessageType type, String id, final boolean base)
	{
		setCategory(category);
		setType(type);
		setId(id);
		setIsBase(base);
	}
	
	private MessageCategory _category;
	private MessageType _type;
	private String _id;
	private boolean _base;

	public MessageCategory getCategory() {
		return this._category;
	}
	private void setCategory(final MessageCategory category) {
		this._category = category;
	}
	public MessageType getType() {
		return this._type;
	}
	private void setType(final MessageType type) {
		this._type = type;
	}
	public String getId() {
		return this._id;
	}
	private void setId(final String id) {
		this._id = id;
	}
	
	public boolean getIsBase()
	{
		return this._base;
	}
	
	private void setIsBase(final boolean base)
	{
		this._base = base;
	}
	
	public String getIdentifier()
	{
		return StringTool.concatenate(this.getCategory().name(), UNDERSCORE, this.getType().name(), UNDERSCORE, this.getId());
	}
}
