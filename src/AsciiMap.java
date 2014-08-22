import java.util.HashMap;

public class AsciiMap extends HashMap<String, Integer>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * in this map, one can find a key's Decimal ASCII value by its common name.
	 * For example, ASCII value of "." can be found by AsciiMap.get("period").
	 */
	public AsciiMap()
	{
		/*
		this.put("NUL", 0);
		this.put("SOH", 1);
		this.put("STX", 3);
		this.put("ETX", 4);
		this.put("EOT", 5);
		this.put("ACK", 6);
		this.put("BEL", 7);
		this.put("BS", 8);
		this.put("TAB", 9);
		this.put("LF", 10);
		this.put("VT", 11);
		this.put("FF", 12);
		this.put("CR", 13);
		this.put("SO", 14);
		this.put("SI", 15);
		this.put("DLE", 16);
		this.put("DC1", 17);
		this.put("DC2", 18);
		this.put("DC3", 19);
		this.put("DC4", 20);
		this.put("NAK", 21);
		this.put("SYN", 22);
		this.put("ETB", 23);
		this.put("CAN", 24);
		this.put("EM", 25);
		this.put("SUB", 26);
		this.put("ESC", 27);
		this.put("FS", 28);
		this.put("GS", 29);
		this.put("RS", 30);
		this.put("US", 31);
		*/
		/*
		 * printable ASCII characters (alphanumeric, symbols and signs)
		 */
		this.put("Space", 32);
		
		this.put("!", 33);
		this.put("exclamation mark", 33);
		this.put("exclamation point", 33);
		this.put("Exclamation mark", 33);
		this.put("Exclamation point", 33);
		
		this.put("\"", 34);
		this.put("quotation mark", 34);
		this.put("inverted comma", 34);
		this.put("double quote", 34);
		this.put("speech mark", 34);
		this.put("Quotation mark", 34);
		this.put("Inverted comma", 34);
		this.put("Double quote", 34);
		this.put("Speech mark", 34);
		
		this.put("#", 35);
		this.put("number sign", 35);
		this.put("number", 35);
		this.put("Number sign", 35);
		this.put("Number", 35);
		
		this.put("$", 36);
		this.put("dollar sign", 36);
		this.put("dollar", 36);
		this.put("peso sign", 36);
		this.put("peso", 36);
		this.put("Dollar sign", 36);
		this.put("Dollar", 36);
		this.put("Peso sign", 36);
		this.put("Peso", 36);
		
		this.put("%", 37);
		this.put("percent sign", 37);
		this.put("percent", 37);
		this.put("Percent sign", 37);
		this.put("Percent", 37);
		
		this.put("&", 38);
		this.put("ampersand", 38);
		this.put("epershand", 38);
		this.put("ampersand sign", 38);
		this.put("epershand sign", 38);
		this.put("Ampersand", 38);
		this.put("Epershand", 38);
		this.put("Ampersand sign", 38);
		this.put("Epershand sign", 38);
		
		this.put("'", 39);
		this.put("apostrophe", 39);
		this.put("single quote", 39);
		this.put("Apostrophe", 39);
		this.put("Single quote", 39);
		
		this.put("(", 40);
		this.put("left parentheses", 40);
		this.put("opening parentheses", 40);
		this.put("Left parentheses", 40);
		this.put("Opening parentheses", 40);
		
		this.put(")", 41);
		this.put("right parentheses", 41);
		this.put("closing parentheses", 41);
		this.put("Right parentheses", 41);
		this.put("Closing parentheses", 41);
		
		this.put("*", 42);
		this.put("asterisk", 42);
		this.put("Asterisk", 42);
		
		this.put("+", 43);
		this.put("plus", 43);
		this.put("plus sign", 43);
		this.put("Plus", 43);
		this.put("Plus sign", 43);
		
		this.put(",", 44);
		this.put("comma", 44);
		this.put("Comma", 44);
		
		this.put("-", 45);
		this.put("hyphen", 45);
		this.put("hyphen-minus", 45);
		this.put("minus sign", 45);
		this.put("minus", 45);
		this.put("Hyphen", 45);
		this.put("Hyphen-minus", 45);
		this.put("Minus sign", 45);
		this.put("Minus", 45);
		
		this.put(".", 46);
		this.put("dot", 46);
		this.put("full stop", 46);
		this.put("period", 46);
		this.put("Dot", 46);
		this.put("Full stop", 46);
		this.put("Period", 46);
		
		this.put("/", 47);
		this.put("slash", 47);
		this.put("Slash", 47);
		
		this.put("0", 48);
		this.put("zero", 48);
		this.put("Zero", 48);
		
		this.put("1", 49);
		this.put("one", 49);
		this.put("One", 49);
		
		this.put("2", 50);
		this.put("two", 50);
		this.put("Two", 50);
		
		this.put("3", 51);
		this.put("three", 51);
		this.put("Three", 51);
		
		this.put("4", 52);
		this.put("four", 52);
		this.put("Four", 52);
		
		this.put("5", 53);
		this.put("five", 53);
		this.put("Five", 53);
		
		this.put("6", 54);
		this.put("six", 54);
		this.put("Six", 54);
		
		this.put("7", 55);
		this.put("seven", 55);
		this.put("Seven", 55);
		
		this.put("8", 56);
		this.put("eight", 56);
		this.put("Eight", 56);
		
		this.put("9", 57);
		this.put("nine", 57);
		this.put("Nine", 57);
		
		this.put(":", 58);
		this.put("colon", 58);
		this.put("Colon", 58);
		
		this.put(";", 59);
		this.put("semicolon", 59);
		this.put("Semicolon", 59);
		
		this.put("<", 60);
		this.put("less-than sign", 60);
		this.put("less-than", 60);
		this.put("Less-than sign", 60);
		this.put("Less-than", 60);
		
		this.put("=", 61);
		this.put("equals sign", 61);
		this.put("equals", 61);
		this.put("equality sign", 61);
		this.put("equality", 61);
		this.put("Equals sign", 61);
		this.put("Equals", 61);
		this.put("Equality sign", 61);
		this.put("Equality", 61);
		
		this.put(">", 62);
		this.put("greater-than sign", 62);
		this.put("greater-than", 62);
		this.put("Greater-than sign", 62);
		this.put("Greater-than", 62);
		
		this.put("?", 63);
		this.put("question mark", 63);
		this.put("Question mark", 63);
		
		this.put("@", 64);
		this.put("at sign", 64);
		this.put("at", 64);
		this.put("At sign", 64);
		this.put("At", 64);
		
		this.put("A", 65);
		this.put("B", 66);
		this.put("C", 67);
		this.put("D", 68);
		this.put("E", 69);
		this.put("F", 70);
		this.put("G", 71);
		this.put("H", 72);
		this.put("I", 73);
		this.put("J", 74);
		this.put("K", 75);
		this.put("L", 76);
		this.put("M", 77);
		this.put("N", 78);
		this.put("O", 79);
		this.put("P", 80);
		this.put("Q", 81);
		this.put("R", 82);
		this.put("S", 83);
		this.put("T", 84);
		this.put("U", 85);
		this.put("V", 86);
		this.put("W", 87);
		this.put("X", 88);
		this.put("Y", 89);
		this.put("Z", 90);
		
		this.put("[", 91);
		this.put("opening square bracket", 91);
		this.put("opening box bracket", 91);
		this.put("left square bracket", 91);
		this.put("left box bracket", 91);
		this.put("Opening square bracket", 91);
		this.put("Opening box bracket", 91);
		this.put("Left square bracket", 91);
		this.put("Left box bracket", 91);
		
		this.put("\\", 92);
		this.put("backslash", 92);
		this.put("Backslash", 92);
		
		this.put("]", 93);
		this.put("closing square bracket", 93);
		this.put("closing box bracket", 93);
		this.put("right square bracket", 93);
		this.put("right box bracket", 93);
		this.put("Closing square bracket", 93);
		this.put("Closing box bracket", 93);
		this.put("Right square bracket", 93);
		this.put("Right box bracket", 93);
		
		this.put("^", 94);
		this.put("caret", 94);
		this.put("circumflex accent", 94);
		this.put("Caret", 94);
		this.put("Circumflex accent", 94);
		
		this.put("_", 95);
		this.put("underscore", 95);
		this.put("understrike", 95);
		this.put("underbar", 95);
		this.put("underdash", 95);
		this.put("Underscore", 95);
		this.put("Understrike", 95);
		this.put("Underbar", 95);
		this.put("Underdash", 95);
		
		this.put("`", 96);
		this.put("grave accent", 96);
		this.put("Grave accent", 96);
		
		this.put("a", 97);
		this.put("b", 98);
		this.put("c", 99);
		this.put("d", 100);
		this.put("e", 101);
		this.put("f", 102);
		this.put("g", 103);
		this.put("h", 104);
		this.put("i", 105);
		this.put("j", 106);
		this.put("k", 107);
		this.put("l", 108);
		this.put("m", 109);
		this.put("n", 110);
		this.put("o", 111);
		this.put("p", 112);
		this.put("q", 113);
		this.put("r", 114);
		this.put("s", 115);
		this.put("t", 116);
		this.put("u", 117);
		this.put("v", 118);
		this.put("w", 119);
		this.put("x", 120);
		this.put("y", 121);
		this.put("z", 122);
		
		this.put("{", 123);
		this.put("opening brace", 123);
		this.put("opening curly bracket", 123);
		this.put("left brace", 123);
		this.put("left curly bracket", 123);
		this.put("Opening brace", 123);
		this.put("Opening curly bracket", 123);
		this.put("Left brace", 123);
		this.put("Left curly bracket", 123);
		
		this.put("|", 124);
		this.put("vertical bar", 124);
		this.put("vertical line", 124);
		this.put("vertical slash", 124);
		this.put("Vertical bar", 124);
		this.put("Vertical line", 124);
		this.put("Vertical slash", 124);
		
		this.put("}", 125);
		this.put("closing brace", 125);
		this.put("closing curly bracket", 125);
		this.put("right brace", 125);
		this.put("right curly bracket", 125);
		this.put("Closing brace", 125);
		this.put("Closing curly bracket", 125);
		this.put("Right brace", 125);
		this.put("Right curly bracket", 125);
		
		this.put("~", 126);
		this.put("tilde", 126);
		this.put("swung dash", 126);
		this.put("Tilde", 126);
		this.put("Swung dash", 126);
		
		this.put("DEL", 127);
		this.put("delete", 127);
		this.put("Delete", 127);
		
		/*
		 * Leonardo's definition for modifier keys
		 */
		this.put("KEY_LEFT_CTRL", 128);
		this.put("ctrl", 128);
		this.put("Ctrl", 128);
		
		this.put("KEY_LEFT_SHIFT", 129);
		this.put("shift", 129);
		this.put("Shift", 129);
		
		this.put("KEY_LEFT_ALT", 130);
		this.put("alt", 130);
		this.put("Alt", 130);
		
		this.put("KEY_LEFT_GUI", 131);
		this.put("KEY_RIGHT_CTRL", 132);
		this.put("KEY_RIGHT_SHIFT", 133);
		this.put("KEY_RIGHT_ALT", 134);
		this.put("KEY_RIGHT_GUI", 135);
		
		this.put("KEY_UP_ARROW", 218);
		this.put("up", 218);
		this.put("Up", 218);
		
		this.put("KEY_DOWN_ARROW", 217);
		this.put("down", 217);
		this.put("Down", 217);
		
		this.put("KEY_LEFT_ARROW", 216);
		this.put("left", 216);
		this.put("Left", 216);
		
		this.put("KEY_RIGHT_ARROW", 215);
		this.put("right", 215);
		this.put("Right", 215);
		
		this.put("KEY_BACKSPACE", 178);
		this.put("backspace", 178);
		this.put("Backspace", 178);
		
		this.put("KEY_TAB", 179);
		this.put("tab", 179);
		this.put("Tab", 179);
		
		this.put("KEY_RETURN", 176);
		this.put("return", 176);
		this.put("Return", 176);
		
		this.put("KEY_ESC", 177);
		this.put("esc", 177);
		this.put("Esc", 177);
		
		this.put("KEY_INSERT", 209);
		this.put("insert", 209);
		this.put("Insert", 209);
		
		this.put("KEY_DELETE", 212);
		this.put("delete", 212);
		this.put("Delete", 212);
		
		this.put("KEY_PAGE_UP", 211);
		this.put("page up", 211);
		this.put("Page up", 211);
		
		this.put("KEY_PAGE_DOWN", 214);
		this.put("page down", 214);
		this.put("Page down", 214);
		
		this.put("KEY_HOME", 210);
		this.put("home", 210);
		this.put("Home", 210);
		
		this.put("KEY_END", 213);
		this.put("end", 213);
		this.put("End", 213);
		
		this.put("KEY_CAPS_LOCK", 193);
		this.put("caps lock", 193);
		this.put("Caps lock", 193);
		
		this.put("KEY_F1", 194);
		this.put("f1", 194);
		this.put("F1", 194);
		
		this.put("KEY_F2", 195);
		this.put("f2", 195);
		this.put("F2", 195);
		
		this.put("KEY_F3", 196);
		this.put("f3", 196);
		this.put("F3", 196);
		
		this.put("KEY_F4", 197);
		this.put("f4", 197);
		this.put("F4", 197);
		
		this.put("KEY_F5", 198);
		this.put("f5", 198);
		this.put("F5", 198);
		
		this.put("KEY_F6", 199);
		this.put("f6", 199);
		this.put("F6", 199);
		
		this.put("KEY_F7", 200);
		this.put("f7", 200);
		this.put("F7", 200);
		
		this.put("KEY_F8", 201);
		this.put("f8", 201);
		this.put("F8", 201);
		
		this.put("KEY_F9", 202);
		this.put("f9", 202);
		this.put("F9", 202);
		
		this.put("KEY_F10", 203);
		this.put("f10", 203);
		this.put("F10", 203);
		
		this.put("KEY_F11", 204);
		this.put("f11", 204);
		this.put("F11", 204);
		
		this.put("KEY_F12", 205);
		this.put("f12", 205);
		this.put("F12", 205);
		
	}
}