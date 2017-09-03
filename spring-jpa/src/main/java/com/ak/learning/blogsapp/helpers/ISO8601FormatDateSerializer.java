package com.ak.learning.blogsapp.helpers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ISO8601FormatDateSerializer extends JsonSerializer {
  private static final SimpleDateFormat dateFormat
      = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

  @Override
  public void serialize(Object o, JsonGenerator gen, SerializerProvider provider)
      throws IOException, JsonProcessingException {

    if (o instanceof Date) {
      Date date = (Date) o;
      String iso8601FormattedString = dateFormat.format(date);
      gen.writeString(iso8601FormattedString);
    }
  }
}
