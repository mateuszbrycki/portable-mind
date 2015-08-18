package com.portablemind.cardCategory;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Mateusz Brycki on 17/08/2015.
 */
public class CardCategoryDTO extends CardCategory {

   private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
