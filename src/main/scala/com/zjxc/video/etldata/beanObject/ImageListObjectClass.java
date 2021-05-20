package com.zjxc.video.etldata.beanObject;

import java.util.List;

public class ImageListObjectClass {

    /**
     * ImageListObject : {"Image":[{"PersonList":{},"FaceList":{},"MotorVehicleList":{},"NonMotorVehicleList":{},"ThingList":{},"SceneList":{},"ImageInfo":{"ImageID":"33010101001190330101022017093009520000116","InfoKind":1,"ImageSource":"99","EventSort":1,"StoragePath":"VMS_2016-06/d999f7d26e27486fbfafbece912f8126.dav","ShotTime":"20160612103006","ShotPlaceFullAdress":"0606IPC","ShotPlaceLongitude":120.21187945483,"ShotPlaceLatitude":30.224528916891,"EntryClerkOrg":"杭州","EntryTime":"20160621101908","FileHash":"@dsec1098","FileFormat":"Jpeg","Title":"测试图","ContentDescription":"测试用的哇","Width":100,"Height":78,"SecurityLevel":5,"FileSize":64427063296},"Data":"${carNumPicBase64}"}]}
     */

    private ImageListObjectBean ImageListObject;

    public ImageListObjectBean getImageListObject() {
        return ImageListObject;
    }

    public void setImageListObject(ImageListObjectBean ImageListObject) {
        this.ImageListObject = ImageListObject;
    }

    public static class ImageListObjectBean {
        private List<ImageBean> Image;

        public List<ImageBean> getImage() {
            return Image;
        }

        public void setImage(List<ImageBean> Image) {
            this.Image = Image;
        }

        public static class ImageBean {
            /**
             * PersonList : {}
             * FaceList : {}
             * MotorVehicleList : {}
             * NonMotorVehicleList : {}
             * ThingList : {}
             * SceneList : {}
             * ImageInfo : {"ImageID":"33010101001190330101022017093009520000116","InfoKind":1,"ImageSource":"99","EventSort":1,"StoragePath":"VMS_2016-06/d999f7d26e27486fbfafbece912f8126.dav","ShotTime":"20160612103006","ShotPlaceFullAdress":"0606IPC","ShotPlaceLongitude":120.21187945483,"ShotPlaceLatitude":30.224528916891,"EntryClerkOrg":"杭州","EntryTime":"20160621101908","FileHash":"@dsec1098","FileFormat":"Jpeg","Title":"测试图","ContentDescription":"测试用的哇","Width":100,"Height":78,"SecurityLevel":5,"FileSize":64427063296}
             * Data : ${carNumPicBase64}
             */

            private PersonListBean PersonList;
            private FaceListBean FaceList;
            private MotorVehicleListBean MotorVehicleList;
            private NonMotorVehicleListBean NonMotorVehicleList;
            private ThingListBean ThingList;
            private SceneListBean SceneList;
            private ImageInfoBean ImageInfo;
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

            public ImageInfoBean getImageInfo() {
                return ImageInfo;
            }

            public void setImageInfo(ImageInfoBean ImageInfo) {
                this.ImageInfo = ImageInfo;
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

            public static class ImageInfoBean {
                /**
                 * ImageID : 33010101001190330101022017093009520000116
                 * InfoKind : 1
                 * ImageSource : 99
                 * EventSort : 1
                 * StoragePath : VMS_2016-06/d999f7d26e27486fbfafbece912f8126.dav
                 * ShotTime : 20160612103006
                 * ShotPlaceFullAdress : 0606IPC
                 * ShotPlaceLongitude : 120.21187945483
                 * ShotPlaceLatitude : 30.224528916891
                 * EntryClerkOrg : 杭州
                 * EntryTime : 20160621101908
                 * FileHash : @dsec1098
                 * FileFormat : Jpeg
                 * Title : 测试图
                 * ContentDescription : 测试用的哇
                 * Width : 100
                 * Height : 78
                 * SecurityLevel : 5
                 * FileSize : 64427063296
                 */

                private String ImageID;
                private int InfoKind;
                private String ImageSource;
                private int EventSort;
                private String StoragePath;
                private String ShotTime;
                private String ShotPlaceFullAdress;
                private double ShotPlaceLongitude;
                private double ShotPlaceLatitude;
                private String EntryClerkOrg;
                private String EntryTime;
                private String FileHash;
                private String FileFormat;
                private String Title;
                private String ContentDescription;
                private int Width;
                private int Height;
                private int SecurityLevel;
                private long FileSize;

                public String getImageID() {
                    return ImageID;
                }

                public void setImageID(String ImageID) {
                    this.ImageID = ImageID;
                }

                public int getInfoKind() {
                    return InfoKind;
                }

                public void setInfoKind(int InfoKind) {
                    this.InfoKind = InfoKind;
                }

                public String getImageSource() {
                    return ImageSource;
                }

                public void setImageSource(String ImageSource) {
                    this.ImageSource = ImageSource;
                }

                public int getEventSort() {
                    return EventSort;
                }

                public void setEventSort(int EventSort) {
                    this.EventSort = EventSort;
                }

                public String getStoragePath() {
                    return StoragePath;
                }

                public void setStoragePath(String StoragePath) {
                    this.StoragePath = StoragePath;
                }

                public String getShotTime() {
                    return ShotTime;
                }

                public void setShotTime(String ShotTime) {
                    this.ShotTime = ShotTime;
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

                public int getWidth() {
                    return Width;
                }

                public void setWidth(int Width) {
                    this.Width = Width;
                }

                public int getHeight() {
                    return Height;
                }

                public void setHeight(int Height) {
                    this.Height = Height;
                }

                public int getSecurityLevel() {
                    return SecurityLevel;
                }

                public void setSecurityLevel(int SecurityLevel) {
                    this.SecurityLevel = SecurityLevel;
                }

                public long getFileSize() {
                    return FileSize;
                }

                public void setFileSize(long FileSize) {
                    this.FileSize = FileSize;
                }
            }
        }
    }
}
