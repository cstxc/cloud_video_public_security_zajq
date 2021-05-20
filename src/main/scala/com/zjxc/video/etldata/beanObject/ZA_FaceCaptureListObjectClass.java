package com.zjxc.video.etldata.beanObject;
/*
 *@ClassName  FaceListZAObjectClass
 *@description    TODO  智安
 *@author     Whoami
 *@date   2020/11/26
 *@version 1.0
 */

import java.util.List;

public class ZA_FaceCaptureListObjectClass {


    /**
     *
     */

    private FaceCaptureListBean FaceCaptureList;

    public FaceCaptureListBean getFaceCaptureList() {
        return FaceCaptureList;
    }

    public void setFaceCaptureList(FaceCaptureListBean FaceCaptureList) {
        this.FaceCaptureList = FaceCaptureList;
    }

    public static class FaceCaptureListBean {
        private List<FaceCaptureObjectBean> FaceCaptureObject;

        public List<FaceCaptureObjectBean> getFaceCaptureObject() {
            return FaceCaptureObject;
        }

        public void setFaceCaptureObject(List<FaceCaptureObjectBean> FaceCaptureObject) {
            this.FaceCaptureObject = FaceCaptureObject;
        }

        public static class FaceCaptureObjectBean {


            private String SFJSY_PDBZ;
            private boolean hit;
            private String RLZPXXBZ;
            private int brard;
            private int XBDM;
            private int beginTime;
            private String channelCode;
            private int mask;
            private String CJSJ;
            private String SFGZRY_PDBZ;
            private String SPTXXXYYSXDXBZ;
            private String CJSBXXBZ;
            private String SY_YS;
            private int occurrenceCount;
            private String globalScenePicUrl;
            private int eye;
            private int mouth;
            private String faceImgUrl;
            private String XZ_YS;
            private int channelSeq;
            private String RLCJT_URL;
            private int endTime;
            private String TP;
            private int age;
            private String SFBKRY_PDBZ;

            public String getSFJSY_PDBZ() {
                return SFJSY_PDBZ;
            }

            public void setSFJSY_PDBZ(String SFJSY_PDBZ) {
                this.SFJSY_PDBZ = SFJSY_PDBZ;
            }

            public boolean isHit() {
                return hit;
            }

            public void setHit(boolean hit) {
                this.hit = hit;
            }

            public String getRLZPXXBZ() {
                return RLZPXXBZ;
            }

            public void setRLZPXXBZ(String RLZPXXBZ) {
                this.RLZPXXBZ = RLZPXXBZ;
            }

            public int getBrard() {
                return brard;
            }

            public void setBrard(int brard) {
                this.brard = brard;
            }

            public int getXBDM() {
                return XBDM;
            }

            public void setXBDM(int XBDM) {
                this.XBDM = XBDM;
            }

            public int getBeginTime() {
                return beginTime;
            }

            public void setBeginTime(int beginTime) {
                this.beginTime = beginTime;
            }

            public String getChannelCode() {
                return channelCode;
            }

            public void setChannelCode(String channelCode) {
                this.channelCode = channelCode;
            }

            public int getMask() {
                return mask;
            }

            public void setMask(int mask) {
                this.mask = mask;
            }

            public String getCJSJ() {
                return CJSJ;
            }

            public void setCJSJ(String CJSJ) {
                this.CJSJ = CJSJ;
            }

            public String getSFGZRY_PDBZ() {
                return SFGZRY_PDBZ;
            }

            public void setSFGZRY_PDBZ(String SFGZRY_PDBZ) {
                this.SFGZRY_PDBZ = SFGZRY_PDBZ;
            }

            public String getSPTXXXYYSXDXBZ() {
                return SPTXXXYYSXDXBZ;
            }

            public void setSPTXXXYYSXDXBZ(String SPTXXXYYSXDXBZ) {
                this.SPTXXXYYSXDXBZ = SPTXXXYYSXDXBZ;
            }

            public String getCJSBXXBZ() {
                return CJSBXXBZ;
            }

            public void setCJSBXXBZ(String CJSBXXBZ) {
                this.CJSBXXBZ = CJSBXXBZ;
            }

            public String getSY_YS() {
                return SY_YS;
            }

            public void setSY_YS(String SY_YS) {
                this.SY_YS = SY_YS;
            }

            public int getOccurrenceCount() {
                return occurrenceCount;
            }

            public void setOccurrenceCount(int occurrenceCount) {
                this.occurrenceCount = occurrenceCount;
            }

            public String getGlobalScenePicUrl() {
                return globalScenePicUrl;
            }

            public void setGlobalScenePicUrl(String globalScenePicUrl) {
                this.globalScenePicUrl = globalScenePicUrl;
            }

            public int getEye() {
                return eye;
            }

            public void setEye(int eye) {
                this.eye = eye;
            }

            public int getMouth() {
                return mouth;
            }

            public void setMouth(int mouth) {
                this.mouth = mouth;
            }

            public String getFaceImgUrl() {
                return faceImgUrl;
            }

            public void setFaceImgUrl(String faceImgUrl) {
                this.faceImgUrl = faceImgUrl;
            }

            public String getXZ_YS() {
                return XZ_YS;
            }

            public void setXZ_YS(String XZ_YS) {
                this.XZ_YS = XZ_YS;
            }

            public int getChannelSeq() {
                return channelSeq;
            }

            public void setChannelSeq(int channelSeq) {
                this.channelSeq = channelSeq;
            }

            public String getRLCJT_URL() {
                return RLCJT_URL;
            }

            public void setRLCJT_URL(String RLCJT_URL) {
                this.RLCJT_URL = RLCJT_URL;
            }

            public int getEndTime() {
                return endTime;
            }

            public void setEndTime(int endTime) {
                this.endTime = endTime;
            }

            public String getTP() {
                return TP;
            }

            public void setTP(String TP) {
                this.TP = TP;
            }

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }

            public String getSFBKRY_PDBZ() {
                return SFBKRY_PDBZ;
            }

            public void setSFBKRY_PDBZ(String SFBKRY_PDBZ) {
                this.SFBKRY_PDBZ = SFBKRY_PDBZ;
            }
        }
    }
}
