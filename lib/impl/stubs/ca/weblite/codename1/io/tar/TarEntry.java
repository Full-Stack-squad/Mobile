package ca.weblite.codename1.io.tar;


/**
 *  @author Kamran Zafar
 *  
 */
public class TarEntry {

	protected String file;

	protected TarHeader header;

	public TarEntry(String file, String entryName) {
	}

	public TarEntry(byte[] headerBuf) {
	}

	public boolean equals(TarEntry it) {
	}

	public boolean isDescendent(TarEntry desc) {
	}

	public TarHeader getHeader() {
	}

	public String getName() {
	}

	public void setName(String name) {
	}

	public int getUserId() {
	}

	public void setUserId(int userId) {
	}

	public int getGroupId() {
	}

	public void setGroupId(int groupId) {
	}

	public String getUserName() {
	}

	public void setUserName(String userName) {
	}

	public String getGroupName() {
	}

	public void setGroupName(String groupName) {
	}

	public void setIds(int userId, int groupId) {
	}

	public void setModTime(long time) {
	}

	public void setModTime(java.util.Date time) {
	}

	public java.util.Date getModTime() {
	}

	public String getFile() {
	}

	public long getSize() {
	}

	public void setSize(long size) {
	}

	/**
	 *  Checks if the org.xeustechnologies.jtar entry is a directory
	 *  
	 *  @return
	 */
	public boolean isDirectory() {
	}

	/**
	 *  Extract header from File
	 *  
	 *  @param entryName
	 */
	public void extractTarHeader(String entryName) {
	}

	/**
	 *  Calculate checksum
	 *  
	 *  @param buf
	 *  @return
	 */
	public long computeCheckSum(byte[] buf) {
	}

	/**
	 *  Writes the header to the byte buffer
	 *  
	 *  @param outbuf
	 */
	public void writeEntryHeader(byte[] outbuf) {
	}

	/**
	 *  Parses the tar header to the byte buffer
	 *  
	 *  @param header
	 *  @param bh
	 */
	public void parseTarHeader(byte[] bh) {
	}
}
