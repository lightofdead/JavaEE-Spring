package rucifrak.Tabakaev.model.exception;

import java.text.MessageFormat;

public class NewsTypeException  extends  RuntimeException{

    public NewsTypeException(final Long id){
        super(MessageFormat.format("Could not find NewsType with id:{0}", id));
    }
}
