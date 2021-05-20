package ca.weblite.codename1.io.tar;


/**
 *  @author Kamran Zafar
 *  
 */
public class TarOutputStream extends com.codename1.io.BufferedOutputStream {

	public TarOutputStream(java.io.OutputStream out) {
	}

	/**
	 *  Appends the EOF record and closes the stream
	 *  
	 *  @see java.io.FilterOutputStream#close()
	 */
	@java.lang.Override
	public void close() {
	}

	/**
	 *  Writes a byte to the stream and updates byte counters
	 *  
	 *  @see java.io.FilterOutputStream#write(int)
	 */
	@java.lang.Override
	public void write(int b) {
	}

	/**
	 *  Checks if the bytes being written exceed the current entry size.
	 *  
	 *  @see java.io.FilterOutputStream#write(byte[], int, int)
	 */
	@java.lang.Override
	public void write(byte[] b, int off, int len) {
	}

	/**
	 *  Writes the next tar entry header on the stream
	 *  
	 *  @param entry
	 *  @throws IOException
	 */
	public void putNextEntry(TarEntry entry) {
	}

	/**
	 *  Closes the current tar entry
	 *  
	 *  @throws IOException
	 */
	protected void closeCurrentEntry() {
	}

	/**
	 *  Pads the last content block
	 *  
	 *  @throws IOException
	 */
	protected void pad() {
	}
}
