package com.huoyu.gmap.svr.gmap.protocl;

import com.huoyu.gmap.svr.gmap.datastruct.Point;
import com.huoyu.gmap.svr.gmap.protocl.tool.MsgPo;
import com.huoyu.gmap.svr.gsrc.constant.ServiceType;

public class MsgSetPoint extends MsgPo {
    //请求参数
    public Point    point;     //顶点

    // 回应参数
    public MsgSetPoint() {
        super(10240, true, (short)ServiceType.GMAP.value());
    }

    @Override
    public boolean Build(boolean isResult) {
        if ( isResult ) return false;//不创建回应报文

        SetId((short) ProtoclNo.SET_POINT.value(), isResult);
        defaultParam();
        return addPoint(point);
    }

    @Override
    public boolean Parse() {
        if ( !super.Parse() ) return false;
        if ( !isResult() ) return false;//不应该收到请求报文

        return true;

    }
}
