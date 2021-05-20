package ca.weblite.codename1.io.tar;


/**
 *  Header
 *  
 *  <pre>
 *  Offset  Size     Field
 *  0       100      File name
 *  100     8        File mode
 *  108     8        Owner's numeric user ID
 *  116     8        Group's numeric user ID
 *  124     12       File size in bytes
 *  136     12       Last modification time in numeric Unix time format
 *  148     8        Checksum for header block
 *  156     1        Link indicator (file type)
 *  157     100      Name of linked file
 *  </pre>
 *  
 *  
 *  File Types
 *  
 *  <pre>
 *  Value        Meaning
 *  '0'          Normal file
 *  (ASCII NUL)  Normal file (now obsolete)
 *  '1'          Hard link
 *  '2'          Symbolic link
 *  '3'          Character special
 *  '4'          Block special
 *  '5'          Directory
 *  '6'          FIFO
 *  '7'          Contigous
 *  </pre>
 *  
 *  
 *  
 *  Ustar header
 *  
 *  <pre>
 *  Offset  Size    Field
 *  257     6       UStar indicator "ustar"
 *  263     2       UStar version "00"
 *  265     32      Owner user name
 *  297     32      Owner group name
 *  329     8       Device major number
 *  337     8       Device minor number
 *  345     155     Filename prefix
 *  </pre>
 */
public class TarHeader {

	public static final int NAMELEN = 100;

	public static final int MODELEN = 8;

	public static final int UIDLEN = 8;

	public static final int GIDLEN = 8;

	public static final int SIZELEN = 12;

	public static final int MODTIMELEN = 12;

	public static final int CHKSUMLEN = 8;

	public static final byte LF_OLDNORM = 0;

	public static final byte LF_NORMAL = 48;

	public static final byte LF_LINK = 49;

	public static final byte LF_SYMLINK = 50;

	public static final byte LF_CHR = 51;

	public static final byte LF_BLK = 52;

	public static final byte LF_DIR = 53;

	public static final byte LF_FIFO = 54;

	public static final byte LF_CONTIG = 55;

	public static final int MAGICLEN = 8;

	/**
	 *  The magic tag representing a POSIX tar archive.
	 */
	public static final String TMAGIC = "ustar";

	/**
	 *  The magic tag representing a GNU tar archive.
	 */
	public static final String GNU_TMAGIC = "ustar  ";

	public static final int UNAMELEN = 32;

	public static final int GNAMELEN = 32;

	public static final int DEVLEN = 8;

	public StringBuilder name;

	public int mode;

	public int userId;

	public int groupId;

	public long size;

	public long modTime;

	public int checkSum;

	public byte linkFlag;

	public StringBuilder linkName;

	public StringBuilder magic;

	public StringBuilder userName;

	public StringBuilder groupName;

	public int devMajor;

	public int devMinor;

	public TarHeader() {
	}

	/**
	 *  Parse an entry name from a header buffer.
	 *  
	 *  @param name
	 *  @param header
	 *             The header buffer from which to parse.
	 *  @param offset
	 *             The offset into the buffer from which to parse.
	 *  @param length
	 *             The number of header bytes to parse.
	 *  @return The header's entry name.
	 */
	public static StringBuilder parseName(byte[] header, int offset, int length) {
	}

	/**
	 *  Determine the number of bytes in an entry name.
	 *  
	 *  @param name
	 *  @param header
	 *             The header buffer from which to parse.
	 *  @param offset
	 *             The offset into the buffer from which to parse.
	 *  @param length
	 *             The number of header bytes to parse.
	 *  @return The number of bytes in a header's entry name.
	 */
	public static int getNameBytes(StringBuilder name, byte[] buf, int offset, int length) {
	}
}
