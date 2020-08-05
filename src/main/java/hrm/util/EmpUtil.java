package hrm.util;

import hrm.vo.DepCountVO;
import hrm.vo.DepartmentVO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmpUtil {

    // 10
    public static String q(String msg) {
        return "(" + msg + ")";
    }

    // AdminiStration(10)
    public static String tname(DepartmentVO dpVO) {
        return dpVO.getDepartmentName() + q(dpVO.getDepartmentId() + "");
    }


    // AdminiStration(10)
    public static String tname(DepCountVO dcVO) {
        return dcVO.getDepartmentName() + q(dcVO.getDepartmentId() + "");
    }
}
