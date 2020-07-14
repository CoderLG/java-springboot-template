package lg.dto.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class ImageParamsVo {

    @NotBlank
    private String imageName;

    @NotBlank
    private  String geo;

}
