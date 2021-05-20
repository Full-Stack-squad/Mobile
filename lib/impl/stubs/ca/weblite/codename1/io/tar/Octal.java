package ca.weblite.codename1.io.tar;


/**
 *  @author Kamran Zafar
 *  
 */
public class Octal {

	public Octal() {
	}

	/**
	 *  Parse an octal string from a header buffer. This is used for the file
	 *  permission mode value.
	 *  
	 *  @param header
	 *             The header buffer from which to parse.
	 *  @param offset
	 *             The offset into the buffer from which to parse.
	 *  @param length
	 *             The number of header bytes to parse.
	 *  
	 *  @return The long value of the octal string.
	 */
	public static long parseOctal(byte[] header, int offset, int length) {
	}

	/**
	 *  Parse an octal integer from a header buffer.
	 *  
	 *  @param value
	 *  @param buf
	 *             The header buffer from which to parse.
	 *  @param offset
	 *             The offset into the buffer from which to parse.
	 *  @param length
	 *             The number of header bytes to parse.
	 *  
	 *  @return The integer value of the octal bytes.
	 */
	public static int getOctalBytes(long value, byte[] buf, int offset, int length) {
	}

	/**
	 *  Parse the checksum octal integer from a header buffer.
	 *  
	 *  @param value
	 *  @param buf
	 *             The header buffer from which to parse.
	 *  @param offset
	 *             The offset into the buffer from which to parse.
	 *  @param length
	 *             The number of header bytes to parse.
	 *  @return The integer value of the entry's checksum.
	 */
	public static int getCheckSumOctalBytes(long value, byte[] buf, int offset, int length) {
	}

	/**
	 *  Parse an octal long integer from a header buffer.
	 *  
	 *  @param value
	 *  @param buf
	 *             The header buffer from which to parse.
	 *  @param offset
	 *             The offset into the buffer from which to parse.
	 *  @param length
	 *             The number of header bytes to parse.
	 *  
	 *  @return The long value of the octal bytes.
	 */
	public static int getLongOctalBytes(long value, byte[] buf, int offset, int length) {
	}
}
