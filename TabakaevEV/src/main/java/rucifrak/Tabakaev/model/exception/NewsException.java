package rucifrak.Tabakaev.model.exception;

import java.text.MessageFormat;

public class NewsException extends  RuntimeException{
    public NewsException(final Long id){
        super(MessageFormat.format("Could not find News with id:{0}", id));
    }
}
