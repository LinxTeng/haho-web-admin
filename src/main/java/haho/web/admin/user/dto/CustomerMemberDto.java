package haho.web.admin.user.dto;

public class CustomerMemberDto {

    private Long id;


    private String name;


    private String mobile;


    private Long shopId;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getMobile() {
        return mobile;
    }


    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    public Long getShopId() {
        return shopId;
    }


    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }


    @Override
    public String toString() {
        return "CustomerMemberDto [id=" + id + ", name=" + name + ", mobile=" + mobile + ", shopId=" + shopId + "]";
    }

}
