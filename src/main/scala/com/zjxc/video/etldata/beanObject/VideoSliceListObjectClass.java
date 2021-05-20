package com.zjxc.video.etldata.beanObject;
/*
 *@ClassName  VideoSliceListObjectClass
 *@description    TODO
 *@author     Whoami
 *@date   2020/7/27
 *@version 1.0
 */

import java.util.List;

public class VideoSliceListObjectClass {

    /**
     * VideoSliceListObject : {"VideoSlice":[{"PersonList":{},"FaceList":{},"MotorVehicleList":{},"NonMotorVehicleList":{},"ThingList":{},"SceneList":{},"VideoSliceInfo":{"VideoID":"33080101021190000001012017122111111100011","InfoKind":1,"VideoSource":"3","FileHash":"d@dase231","FileFormat":"Mpg","CodedFormat":"3","AudioFlag":0,"Title":"视频资源","ContentDescription":"视频资源描述","ShotPlaceCode":"33010178","VideoLen":"2345","BeginTime":"20171010152321","EndTime":"20171010152710","StoragePath":"VMS_2016_05/662febcb48a14c8d8b7c498950b4d2d.jpg","ThumbnailStoragePath":"VMS_2016_05/662febcb48a14c8d8b7c498950b4d2d7.jpg","ShotPlaceFullAdress":"111111111","ShotPlaceLongitude":120.178299258351,"ShotPlaceLatitude":30.1892863586333,"EntryClerkOrg":"杭州","EntryTime":"20160525165441","FileSize":69098700},"Data":"${carNumPicBase64}"}]}
     */

    private VideoSliceListObjectBean VideoSliceListObject;

    public VideoSliceListObjectBean getVideoSliceListObject() {
        return VideoSliceListObject;
    }

    public void setVideoSliceListObject(VideoSliceListObjectBean VideoSliceListObject) {
        this.VideoSliceListObject = VideoSliceListObject;
    }

    public static class VideoSliceListObjectBean {
        private List<VideoSliceBean> VideoSlice;

        public List<VideoSliceBean> getVideoSlice() {
            return VideoSlice;
        }

        public void setVideoSlice(List<VideoSliceBean> VideoSlice) {
            this.VideoSlice = VideoSlice;
        }

        public static class VideoSliceBean {
            /**
             * PersonList : {}
             * FaceList : {}
             * MotorVehicleList : {}
             * NonMotorVehicleList : {}
             * ThingList : {}
             * SceneList : {}
             * VideoSliceInfo : {"VideoID":"33080101021190000001012017122111111100011","InfoKind":1,"VideoSource":"3","FileHash":"d@dase231","FileFormat":"Mpg","CodedFormat":"3","AudioFlag":0,"Title":"视频资源","ContentDescription":"视频资源描述","ShotPlaceCode":"33010178","VideoLen":"2345","BeginTime":"20171010152321","EndTime":"20171010152710","StoragePath":"VMS_2016_05/662febcb48a14c8d8b7c498950b4d2d.jpg","ThumbnailStoragePath":"VMS_2016_05/662febcb48a14c8d8b7c498950b4d2d7.jpg","ShotPlaceFullAdress":"111111111","ShotPlaceLongitude":120.178299258351,"ShotPlaceLatitude":30.1892863586333,"EntryClerkOrg":"杭州","EntryTime":"20160525165441","FileSize":69098700}
             * Data : ${carNumPicBase64}
             */

            private PersonListBean PersonList;
            private FaceListBean FaceList;
            private MotorVehicleListBean MotorVehicleList;
            private NonMotorVehicleListBean NonMotorVehicleList;
            private ThingListBean ThingList;
            private SceneListBean SceneList;
            private VideoSliceInfoBean VideoSliceInfo;
            private String Data;

            public PersonListBean getPersonList() {
                return PersonList;
            }

            public void setPersonList(PersonListBean PersonList) {
                this.PersonList = PersonList;
            }

            public FaceListBean getFaceList() {
                return FaceList;
            }

            public void setFaceList(FaceListBean FaceList) {
                this.FaceList = FaceList;
            }

            public MotorVehicleListBean getMotorVehicleList() {
                return MotorVehicleList;
            }

            public void setMotorVehicleList(MotorVehicleListBean MotorVehicleList) {
                this.MotorVehicleList = MotorVehicleList;
            }

            public NonMotorVehicleListBean getNonMotorVehicleList() {
                return NonMotorVehicleList;
            }

            public void setNonMotorVehicleList(NonMotorVehicleListBean NonMotorVehicleList) {
                this.NonMotorVehicleList = NonMotorVehicleList;
            }

            public ThingListBean getThingList() {
                return ThingList;
            }

            public void setThingList(ThingListBean ThingList) {
                this.ThingList = ThingList;
            }

            public SceneListBean getSceneList() {
                return SceneList;
            }

            public void setSceneList(SceneListBean SceneList) {
                this.SceneList = SceneList;
            }

            public VideoSliceInfoBean getVideoSliceInfo() {
                return VideoSliceInfo;
            }

            public void setVideoSliceInfo(VideoSliceInfoBean VideoSliceInfo) {
                this.VideoSliceInfo = VideoSliceInfo;
            }

            public String getData() {
                return Data;
            }

            public void setData(String Data) {
                this.Data = Data;
            }

            public static class PersonListBean {
            }

            public static class FaceListBean {
            }

            public static class MotorVehicleListBean {
            }

            public static class NonMotorVehicleListBean {
            }

            public static class ThingListBean {
            }

            public static class SceneListBean {
            }

            public static class VideoSliceInfoBean {
                /**
                 * VideoID : 33080101021190000001012017122111111100011
                 * InfoKind : 1
                 * VideoSource : 3
                 * FileHash : d@dase231
                 * FileFormat : Mpg
                 * CodedFormat : 3
                 * AudioFlag : 0
                 * Title : 视频资源
                 * ContentDescription : 视频资源描述
                 * ShotPlaceCode : 33010178
                 * VideoLen : 2345
                 * BeginTime : 20171010152321
                 * EndTime : 20171010152710
                 * StoragePath : VMS_2016_05/662febcb48a14c8d8b7c498950b4d2d.jpg
                 * ThumbnailStoragePath : VMS_2016_05/662febcb48a14c8d8b7c498950b4d2d7.jpg
                 * ShotPlaceFullAdress : 111111111
                 * ShotPlaceLongitude : 120.178299258351
                 * ShotPlaceLatitude : 30.1892863586333
                 * EntryClerkOrg : 杭州
                 * EntryTime : 20160525165441
                 * FileSize : 69098700
                 */

                private String VideoID;
                private int InfoKind;
                private String VideoSource;
                private String FileHash;
                private String FileFormat;
                private String CodedFormat;
                private int AudioFlag;
                private String Title;
                private String ContentDescription;
                private String ShotPlaceCode;
                private String VideoLen;
                private String BeginTime;
                private String EndTime;
                private String StoragePath;
                private String ThumbnailStoragePath;
                private String ShotPlaceFullAdress;
                private double ShotPlaceLongitude;
                private double ShotPlaceLatitude;
                private String EntryClerkOrg;
                private String EntryTime;
                private int FileSize;

                public String getVideoID() {
                    return VideoID;
                }

                public void setVideoID(String VideoID) {
                    this.VideoID = VideoID;
                }

                public int getInfoKind() {
                    return InfoKind;
                }

                public void setInfoKind(int InfoKind) {
                    this.InfoKind = InfoKind;
                }

                public String getVideoSource() {
                    return VideoSource;
                }

                public void setVideoSource(String VideoSource) {
                    this.VideoSource = VideoSource;
                }

                public String getFileHash() {
                    return FileHash;
                }

                public void setFileHash(String FileHash) {
                    this.FileHash = FileHash;
                }

                public String getFileFormat() {
                    return FileFormat;
                }

                public void setFileFormat(String FileFormat) {
                    this.FileFormat = FileFormat;
                }

                public String getCodedFormat() {
                    return CodedFormat;
                }

                public void setCodedFormat(String CodedFormat) {
                    this.CodedFormat = CodedFormat;
                }

                public int getAudioFlag() {
                    return AudioFlag;
                }

                public void setAudioFlag(int AudioFlag) {
                    this.AudioFlag = AudioFlag;
                }

                public String getTitle() {
                    return Title;
                }

                public void setTitle(String Title) {
                    this.Title = Title;
                }

                public String getContentDescription() {
                    return ContentDescription;
                }

                public void setContentDescription(String ContentDescription) {
                    this.ContentDescription = ContentDescription;
                }

                public String getShotPlaceCode() {
                    return ShotPlaceCode;
                }

                public void setShotPlaceCode(String ShotPlaceCode) {
                    this.ShotPlaceCode = ShotPlaceCode;
                }

                public String getVideoLen() {
                    return VideoLen;
                }

                public void setVideoLen(String VideoLen) {
                    this.VideoLen = VideoLen;
                }

                public String getBeginTime() {
                    return BeginTime;
                }

                public void setBeginTime(String BeginTime) {
                    this.BeginTime = BeginTime;
                }

                public String getEndTime() {
                    return EndTime;
                }

                public void setEndTime(String EndTime) {
                    this.EndTime = EndTime;
                }

                public String getStoragePath() {
                    return StoragePath;
                }

                public void setStoragePath(String StoragePath) {
                    this.StoragePath = StoragePath;
                }

                public String getThumbnailStoragePath() {
                    return ThumbnailStoragePath;
                }

                public void setThumbnailStoragePath(String ThumbnailStoragePath) {
                    this.ThumbnailStoragePath = ThumbnailStoragePath;
                }

                public String getShotPlaceFullAdress() {
                    return ShotPlaceFullAdress;
                }

                public void setShotPlaceFullAdress(String ShotPlaceFullAdress) {
                    this.ShotPlaceFullAdress = ShotPlaceFullAdress;
                }

                public double getShotPlaceLongitude() {
                    return ShotPlaceLongitude;
                }

                public void setShotPlaceLongitude(double ShotPlaceLongitude) {
                    this.ShotPlaceLongitude = ShotPlaceLongitude;
                }

                public double getShotPlaceLatitude() {
                    return ShotPlaceLatitude;
                }

                public void setShotPlaceLatitude(double ShotPlaceLatitude) {
                    this.ShotPlaceLatitude = ShotPlaceLatitude;
                }

                public String getEntryClerkOrg() {
                    return EntryClerkOrg;
                }

                public void setEntryClerkOrg(String EntryClerkOrg) {
                    this.EntryClerkOrg = EntryClerkOrg;
                }

                public String getEntryTime() {
                    return EntryTime;
                }

                public void setEntryTime(String EntryTime) {
                    this.EntryTime = EntryTime;
                }

                public int getFileSize() {
                    return FileSize;
                }

                public void setFileSize(int FileSize) {
                    this.FileSize = FileSize;
                }
            }
        }
    }
}
