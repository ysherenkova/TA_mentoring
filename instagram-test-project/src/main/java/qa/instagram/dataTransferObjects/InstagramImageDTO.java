package qa.instagram.dataTransferObjects;

import lombok.Data;

import java.util.Date;

@Data
public class InstagramImageDTO {
  final String id;
  final long timestamp;
  final byte[] image;

  private InstagramImageDTO(String id, byte[] content) {
    this.id = id;
    this.timestamp = new Date().getTime();
    image = content;
  }


  public static InstagramImageDTO create(String fileName, byte[] data) {
    return new InstagramImageDTO(fileName, data);
  }
}

