package hrm.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentVO {
    private int departmentId;
    private String departmentName = "NOTYET";
    private int managerId;
    private int locationId;
}
