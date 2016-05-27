package br.com.harada.mockamazon.infra;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.amazonaws.queue.doc._2012_11_05.MessageAttribute;

public class MD5 {
	
	private static final Charset UTF8 = Charset.forName("utf-8");

	public static Optional<String> from(String value) {
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
	        byte[] array = md.digest(value.getBytes());
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < array.length; ++i) {
	          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
	       }
	        return Optional.of(sb.toString());
		} catch (NoSuchAlgorithmException e) {
			return Optional.empty();
		}
	}

	public static Optional<String> from(List<MessageAttribute> attributes) {
		if(attributes.isEmpty()) {
			return Optional.empty();
		}
		List<MessageAttribute> sorted = attributes.stream().sorted((a1,a2)->a1.getName().compareTo(a2.getName())).collect(Collectors.toList());
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
			for (MessageAttribute attr : sorted) {
				byte[] nameBytes = attr.getName().getBytes(UTF8);
				byte[] typeBytes = attr.getValue().getDataType().getBytes(UTF8);
				byte[] valueBytes = attr.getValue().getStringValue().getBytes(UTF8);
				md.update(ByteBuffer.allocate(4).putInt(nameBytes.length).array());
				md.update(nameBytes);
				md.update(ByteBuffer.allocate(4).putInt(typeBytes.length).array());
				md.update(typeBytes);
				md.update((byte)1);
				md.update(ByteBuffer.allocate(4).putInt(valueBytes.length).array());
				md.update(valueBytes);
			}
			byte[] md5 = md.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < md5.length; ++i) {
				sb.append(Integer.toHexString((md5[i] & 0xFF) | 0x100).substring(1, 3));
			}
			return Optional.of(sb.toString());
		} catch (NoSuchAlgorithmException e) {
			return Optional.empty();
		}
	}
}
