package com.zeyigou.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbBrand implements Serializable {
    @Id
    private Long id;

    private String name;

    private String firstChar;

    private static final long serialVersionUID = 1L;

}