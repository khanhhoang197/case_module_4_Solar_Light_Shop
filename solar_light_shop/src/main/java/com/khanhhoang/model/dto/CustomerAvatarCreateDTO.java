package com.khanhhoang.model.dto;

import com.khanhhoang.model.Customer;
import com.khanhhoang.model.LocationRegion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerAvatarCreateDTO {
    private Long id;

    @NotEmpty(message = "Vui lòng nhập tên khách hàng")
    @Size(min = 5, max = 100, message = "Họ tên có độ dài nằm trong khoảng 5 - 100 ký tự")
    private String fullName;

    @Pattern(regexp = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Email không đúng định dạng")
    @NotEmpty(message = "Vui lòng nhập email")
    private String email;
    @NotEmpty(message = "Vui lòng nhập số điện thoại")
    private String phone;


    MultipartFile file;

    private String fileType;

    private Long locationId;
    private String provinceId;
    private String provinceName;
    private String districtId;
    private String districtName;
    private String wardId;
    private String wardName;
    @NotEmpty(message = "Vui lòng nhập địa chỉ")
    private String address;

    public LocationRegion toLocationRegion() {
        return new LocationRegion()
                .setId(locationId)
                .setProvinceId(provinceId)
                .setProvinceName(provinceName)
                .setDistrictId(districtId)
                .setDistrictName(districtName)
                .setWardId(wardId)
                .setWardName(wardName)
                .setAddress(address);
    }

    public Customer toCustomer(LocationRegion locationRegion) {
        return new Customer()
                .setId(id)
                .setFullName(fullName)
                .setEmail(email)
                .setPhone(phone)
                .setLocationRegion(locationRegion);
    }

}
