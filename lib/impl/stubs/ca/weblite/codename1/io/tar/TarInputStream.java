package ca.weblite.codename1.io.tar;


/**
 *  @author Kamran Zafar
 *  
 */
public class TarInputStream extends com.codename1.io.BufferedInputStream {

	public TarInputStream(java.io.InputStream in) {
	}

	@java.lang.Override
	public boolean markSupported() {
	}

	/**
	 *  Not supported
	 *  
	 */
	@java.lang.Override
	public synchronized void mark(int readlimit) {
	}

	/**
	 *  Not supported
	 *  
	 */
	@java.lang.Override
	public synchronized void reset() {
	}

	/**
	 *  Read a byte
	 *  
	 *  @see java.io.FilterInputStream#read()
	 */
	@java.lang.Override
	public int read() {
	}

	/**
	 *  Checks if the bytes being read exceed the entry size and adjusts the byte
	 *  array length. Updates the byte counters
	 *  
	 *  
	 *  @see java.io.FilterInputStream#read(byte[], int, int)
	 */
	@java.lang.Override
	public int read(byte[] b, int off, int len) {
	}

	/**
	 *  Returns the next entry in the tar file
	 *  
	 *  @return TarEntry
	 *  @throws IOException
	 */
	public TarEntry getNextEntry() {
	}

	/**
	 *  Closes the current tar entry
	 *  
	 *  @throws IOException
	 */
	protected void closeCurrentEntry() {
	}

	/**
	 *  Skips the pad at the end of each tar entry file content
	 *  
	 *  @throws IOException
	 */
	protected void skipPad() {
	}

	/**
	 *  Skips 'n' bytes on the InputStream<br>
	 *  Overrides default implementation of skip
	 *  
	 */
	@java.lang.Override
	public long skip(long n) {
	}

	public boolean isDefaultSkip() {
	}

	public void setDefaultSkip(boolean defaultSkip) {
	}
}
