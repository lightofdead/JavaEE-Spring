package rucifrak.Tabakaev.model.exception;

import java.text.MessageFormat;

public class NewsAlreadyAssignedException extends RuntimeException{
    public NewsAlreadyAssignedException(final Long newsId,final Long newsTypeId){
        super(MessageFormat.format("Item :{o} is already assigned to NewsType: {1}", newsId, newsTypeId));
    }
}
