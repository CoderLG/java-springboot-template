package lg.dto.req;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *  @NotEmpty 用在集合类上
 *  @NotBlank 用子啊string上
 *  @NotNull 用在integer上 @NotEmpty不可以用在integer上
 *
 *  @Size 是可以为空的
 *
 *
 *  {
 *   "address": "string.sdf.sdf",
 *   "detail": "ing",
 *   "userName": "lg",
 *   "sex": 1
 *  }
 */
@Data
public class UserVo {


    @NotEmpty
    private String  userName;


    @NotEmpty
    @Size(max = 5, min = 1)
    private String detail;

    @Pattern(regexp = "[^\\s\\\\/:\\*\\?\\\"<>\\|]*[^\\s\\\\/:\\*\\?\\\"<>\\|\\.]$", message = "用户地址不符合: url")
    private String address;


}
