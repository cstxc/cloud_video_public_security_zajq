package com.zjxc.video.etldata.beanObject;
/*
 *@ClassName  MotorVehicleEventListObiectClass
 *@description    TODO
 *@author     Whoami
 *@date   2020/12/1
 *@version 1.0
 */

import java.util.List;

public class ZA_MotorVehicleEventListObiectClass {

    /**
     * MotorVehicleEventList : {"MotorVehicleEventObject":[{"carWayCode":"","devId":"1000539","CJSJ":"20201208164406","CLQJTXBZ":"2774367984094092698617637274831932503593443184","CLXH":"2","JDCCLLXDM":"X99","JDCGCXXBZ":"1607417046875001","CJSBXXBZ":"33070300010020053910","sFWZDCL_PDBZ":"1","JDCHPZLDM":"99","devName":"鸿泰豪苑小区北进口车辆抓拍1","isMotorVehicleReg":0,"GCFX":"1","carImgUrl":"http://172.18.247.230:8082/d/1000539$1$0$0/20201208/16/4406-198132-0.jpg","JDCHPYSDM":"100","carNumPic":"http://172.18.247.230:8082/d/1000539$1$0$0/20201208/16/4406-198132-0.jpg","JDCCSYSDM":"0","devChnName":"鸿泰豪苑小区北进口车辆抓拍1_视频通道_1","CLHPTXBZ":"9589174716333137193172187225147294468971839123","JDCHPHM":"未识别"}]}
     */

    private MotorVehicleEventListBean MotorVehicleEventList;

    public MotorVehicleEventListBean getMotorVehicleEventList() {
        return MotorVehicleEventList;
    }

    public void setMotorVehicleEventList(MotorVehicleEventListBean MotorVehicleEventList) {
        this.MotorVehicleEventList = MotorVehicleEventList;
    }

    public static class MotorVehicleEventListBean {
        private List<MotorVehicleEventObjectBean> MotorVehicleEventObject;

        public List<MotorVehicleEventObjectBean> getMotorVehicleEventObject() {
            return MotorVehicleEventObject;
        }

        public void setMotorVehicleEventObject(List<MotorVehicleEventObjectBean> MotorVehicleEventObject) {
            this.MotorVehicleEventObject = MotorVehicleEventObject;
        }

        public static class MotorVehicleEventObjectBean {
            /**
             * carWayCode :
             * devId : 1000539
             * CJSJ : 20201208164406
             * CLQJTXBZ : 2774367984094092698617637274831932503593443184
             * CLXH : 2
             * JDCCLLXDM : X99
             * JDCGCXXBZ : 1607417046875001
             * CJSBXXBZ : 33070300010020053910
             * sFWZDCL_PDBZ : 1
             * JDCHPZLDM : 99
             * devName : 鸿泰豪苑小区北进口车辆抓拍1
             * isMotorVehicleReg : 0
             * GCFX : 1
             * carImgUrl : http://172.18.247.230:8082/d/1000539$1$0$0/20201208/16/4406-198132-0.jpg
             * JDCHPYSDM : 100
             * carNumPic : http://172.18.247.230:8082/d/1000539$1$0$0/20201208/16/4406-198132-0.jpg
             * JDCCSYSDM : 0
             * devChnName : 鸿泰豪苑小区北进口车辆抓拍1_视频通道_1
             * CLHPTXBZ : 9589174716333137193172187225147294468971839123
             * JDCHPHM : 未识别
             */

            private String carWayCode;
            private String devId;
            private String CJSJ;
            private String CLQJTXBZ;
            private String CLXH;
            private String JDCCLLXDM;
            private String JDCGCXXBZ;
            private String CJSBXXBZ;
            private String sFWZDCL_PDBZ;
            private String JDCHPZLDM;
            private String devName;
            private int isMotorVehicleReg;
            private String GCFX;
            private String carImgUrl;
            private String JDCHPYSDM;
            private String carNumPic;
            private String JDCCSYSDM;
            private String devChnName;
            private String CLHPTXBZ;
            private String JDCHPHM;

            public String getCarWayCode() {
                return carWayCode;
            }

            public void setCarWayCode(String carWayCode) {
                this.carWayCode = carWayCode;
            }

            public String getDevId() {
                return devId;
            }

            public void setDevId(String devId) {
                this.devId = devId;
            }

            public String getCJSJ() {
                return CJSJ;
            }

            public void setCJSJ(String CJSJ) {
                this.CJSJ = CJSJ;
            }

            public String getCLQJTXBZ() {
                return CLQJTXBZ;
            }

            public void setCLQJTXBZ(String CLQJTXBZ) {
                this.CLQJTXBZ = CLQJTXBZ;
            }

            public String getCLXH() {
                return CLXH;
            }

            public void setCLXH(String CLXH) {
                this.CLXH = CLXH;
            }

            public String getJDCCLLXDM() {
                return JDCCLLXDM;
            }

            public void setJDCCLLXDM(String JDCCLLXDM) {
                this.JDCCLLXDM = JDCCLLXDM;
            }

            public String getJDCGCXXBZ() {
                return JDCGCXXBZ;
            }

            public void setJDCGCXXBZ(String JDCGCXXBZ) {
                this.JDCGCXXBZ = JDCGCXXBZ;
            }

            public String getCJSBXXBZ() {
                return CJSBXXBZ;
            }

            public void setCJSBXXBZ(String CJSBXXBZ) {
                this.CJSBXXBZ = CJSBXXBZ;
            }

            public String getSFWZDCL_PDBZ() {
                return sFWZDCL_PDBZ;
            }

            public void setSFWZDCL_PDBZ(String sFWZDCL_PDBZ) {
                this.sFWZDCL_PDBZ = sFWZDCL_PDBZ;
            }

            public String getJDCHPZLDM() {
                return JDCHPZLDM;
            }

            public void setJDCHPZLDM(String JDCHPZLDM) {
                this.JDCHPZLDM = JDCHPZLDM;
            }

            public String getDevName() {
                return devName;
            }

            public void setDevName(String devName) {
                this.devName = devName;
            }

            public int getIsMotorVehicleReg() {
                return isMotorVehicleReg;
            }

            public void setIsMotorVehicleReg(int isMotorVehicleReg) {
                this.isMotorVehicleReg = isMotorVehicleReg;
            }

            public String getGCFX() {
                return GCFX;
            }

            public void setGCFX(String GCFX) {
                this.GCFX = GCFX;
            }

            public String getCarImgUrl() {
                return carImgUrl;
            }

            public void setCarImgUrl(String carImgUrl) {
                this.carImgUrl = carImgUrl;
            }

            public String getJDCHPYSDM() {
                return JDCHPYSDM;
            }

            public void setJDCHPYSDM(String JDCHPYSDM) {
                this.JDCHPYSDM = JDCHPYSDM;
            }

            public String getCarNumPic() {
                return carNumPic;
            }

            public void setCarNumPic(String carNumPic) {
                this.carNumPic = carNumPic;
            }

            public String getJDCCSYSDM() {
                return JDCCSYSDM;
            }

            public void setJDCCSYSDM(String JDCCSYSDM) {
                this.JDCCSYSDM = JDCCSYSDM;
            }

            public String getDevChnName() {
                return devChnName;
            }

            public void setDevChnName(String devChnName) {
                this.devChnName = devChnName;
            }

            public String getCLHPTXBZ() {
                return CLHPTXBZ;
            }

            public void setCLHPTXBZ(String CLHPTXBZ) {
                this.CLHPTXBZ = CLHPTXBZ;
            }

            public String getJDCHPHM() {
                return JDCHPHM;
            }

            public void setJDCHPHM(String JDCHPHM) {
                this.JDCHPHM = JDCHPHM;
            }
        }
    }
}
