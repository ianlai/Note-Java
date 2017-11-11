package algo;

import java.util.HashMap;
import java.util.Map;

public class _535_EncodeAndDecodeTinyURL {

	public static void main(String[] args) {
		Codec codec = new Codec();
		String input = "abcdefghij";
		String encoded = codec.encode(input);
		String decoded = codec.decode(encoded);
		System.out.println(input);
		System.out.println(encoded);
		System.out.println(decoded);
	}
	static class Codec {

	    Map<Integer, String> map;
	    Codec(){
	        map = new HashMap<Integer,String>();
	    }
	    
	    // Encodes a URL to a shortened URL.
	    public String encode(String longUrl) {
	        int key = longUrl.hashCode();
	        map.put(key, longUrl);
	        return Integer.toString(key);
	    }

	    // Decodes a shortened URL to its original URL.
	    public String decode(String shortUrl) {
	        int key = Integer.parseInt(shortUrl);
	        return map.get(key);
	    }
	}

	// Your Codec object will be instantiated and called as such:
	// Codec codec = new Codec();
	// codec.decode(codec.encode(url));

}
