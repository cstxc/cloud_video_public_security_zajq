package com.zjxc.video.etldata.beanObject;
/*
 *@ClassName  ThingListObjectClass
 *@description    TODO
 *@author     Whoami
 *@date   2020/7/24
 *@version 1.0
 */

import java.util.List;

public class ThingListObjectClass {

    /**
     * ThingListObject : {"ThingObject":[{"ThingID":"650100000011900000010220171219100515999830456499","InfoKind":1,"SourceID":"66000000001190123456022017120110101000008","DeviceID":"55000111221190000007","LeftTopX":10,"LeftTopY":10,"RightBtmX":11,"RightBtmY":11,"LocationMarkTime":"19981230010000","AppearTime":"19981230010000","DisappearTime":"19981230010000","Name":"相机","Shape":"圆形","Color":"1","Size":"比较大","Material":"塑料","Characteristic":"耐用","Propertiy":"99","InvolvedObjType":"1","FirearmsAmmunitionType":"1","ToolTraceType":"1","EvidenceType":"1","CaseEvidenceType":"1","SubImageList":{"SubImageInfoObject":[{"ImageID":"33020300001190000001022017122111111100021","EventSort":4,"DeviceID":"55220299011190000253","StoragePath":"http://localhost:9080/testx_108_20170908/a2421c4fde6d4a74ac923e8470d6e7fa.jpg","Type":"13","FileFormat":"Jpeg","ShotTime":"20170925032455","Width":437,"Height":350}]}}]}
     */

    private ThingListObjectBean ThingListObject;

    public ThingListObjectBean getThingListObject() {
        return ThingListObject;
    }

    public void setThingListObject(ThingListObjectBean ThingListObject) {
        this.ThingListObject = ThingListObject;
    }

    public static class ThingListObjectBean {
        private List<ThingObjectBean> ThingObject;

        public List<ThingObjectBean> getThingObject() {
            return ThingObject;
        }

        public void setThingObject(List<ThingObjectBean> ThingObject) {
            this.ThingObject = ThingObject;
        }

        public static class ThingObjectBean {
            /**
             * ThingID : 650100000011900000010220171219100515999830456499
             * InfoKind : 1
             * SourceID : 66000000001190123456022017120110101000008
             * DeviceID : 55000111221190000007
             * LeftTopX : 10
             * LeftTopY : 10
             * RightBtmX : 11
             * RightBtmY : 11
             * LocationMarkTime : 19981230010000
             * AppearTime : 19981230010000
             * DisappearTime : 19981230010000
             * Name : 相机
             * Shape : 圆形
             * Color : 1
             * Size : 比较大
             * Material : 塑料
             * Characteristic : 耐用
             * Propertiy : 99
             * InvolvedObjType : 1
             * FirearmsAmmunitionType : 1
             * ToolTraceType : 1
             * EvidenceType : 1
             * CaseEvidenceType : 1
             * SubImageList : {"SubImageInfoObject":[{"ImageID":"33020300001190000001022017122111111100021","EventSort":4,"DeviceID":"55220299011190000253","StoragePath":"http://localhost:9080/testx_108_20170908/a2421c4fde6d4a74ac923e8470d6e7fa.jpg","Type":"13","FileFormat":"Jpeg","ShotTime":"20170925032455","Width":437,"Height":350}]}
             */

            private String ThingID;
            private int InfoKind;
            private String SourceID;
            private String DeviceID;
            private int LeftTopX;
            private int LeftTopY;
            private int RightBtmX;
            private int RightBtmY;
            private String LocationMarkTime;
            private String AppearTime;
            private String DisappearTime;
            private String Name;
            private String Shape;
            private String Color;
            private String Size;
            private String Material;
            private String Characteristic;
            private String Propertiy;
            private String InvolvedObjType;
            private String FirearmsAmmunitionType;
            private String ToolTraceType;
            private String EvidenceType;
            private String CaseEvidenceType;
            private SubImageListBean SubImageList;

            public String getThingID() {
                return ThingID;
            }

            public void setThingID(String ThingID) {
                this.ThingID = ThingID;
            }

            public int getInfoKind() {
                return InfoKind;
            }

            public void setInfoKind(int InfoKind) {
                this.InfoKind = InfoKind;
            }

            public String getSourceID() {
                return SourceID;
            }

            public void setSourceID(String SourceID) {
                this.SourceID = SourceID;
            }

            public String getDeviceID() {
                return DeviceID;
            }

            public void setDeviceID(String DeviceID) {
                this.DeviceID = DeviceID;
            }

            public int getLeftTopX() {
                return LeftTopX;
            }

            public void setLeftTopX(int LeftTopX) {
                this.LeftTopX = LeftTopX;
            }

            public int getLeftTopY() {
                return LeftTopY;
            }

            public void setLeftTopY(int LeftTopY) {
                this.LeftTopY = LeftTopY;
            }

            public int getRightBtmX() {
                return RightBtmX;
            }

            public void setRightBtmX(int RightBtmX) {
                this.RightBtmX = RightBtmX;
            }

            public int getRightBtmY() {
                return RightBtmY;
            }

            public void setRightBtmY(int RightBtmY) {
                this.RightBtmY = RightBtmY;
            }

            public String getLocationMarkTime() {
                return LocationMarkTime;
            }

            public void setLocationMarkTime(String LocationMarkTime) {
                this.LocationMarkTime = LocationMarkTime;
            }

            public String getAppearTime() {
                return AppearTime;
            }

            public void setAppearTime(String AppearTime) {
                this.AppearTime = AppearTime;
            }

            public String getDisappearTime() {
                return DisappearTime;
            }

            public void setDisappearTime(String DisappearTime) {
                this.DisappearTime = DisappearTime;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }

            public String getShape() {
                return Shape;
            }

            public void setShape(String Shape) {
                this.Shape = Shape;
            }

            public String getColor() {
                return Color;
            }

            public void setColor(String Color) {
                this.Color = Color;
            }

            public String getSize() {
                return Size;
            }

            public void setSize(String Size) {
                this.Size = Size;
            }

            public String getMaterial() {
                return Material;
            }

            public void setMaterial(String Material) {
                this.Material = Material;
            }

            public String getCharacteristic() {
                return Characteristic;
            }

            public void setCharacteristic(String Characteristic) {
                this.Characteristic = Characteristic;
            }

            public String getPropertiy() {
                return Propertiy;
            }

            public void setPropertiy(String Propertiy) {
                this.Propertiy = Propertiy;
            }

            public String getInvolvedObjType() {
                return InvolvedObjType;
            }

            public void setInvolvedObjType(String InvolvedObjType) {
                this.InvolvedObjType = InvolvedObjType;
            }

            public String getFirearmsAmmunitionType() {
                return FirearmsAmmunitionType;
            }

            public void setFirearmsAmmunitionType(String FirearmsAmmunitionType) {
                this.FirearmsAmmunitionType = FirearmsAmmunitionType;
            }

            public String getToolTraceType() {
                return ToolTraceType;
            }

            public void setToolTraceType(String ToolTraceType) {
                this.ToolTraceType = ToolTraceType;
            }

            public String getEvidenceType() {
                return EvidenceType;
            }

            public void setEvidenceType(String EvidenceType) {
                this.EvidenceType = EvidenceType;
            }

            public String getCaseEvidenceType() {
                return CaseEvidenceType;
            }

            public void setCaseEvidenceType(String CaseEvidenceType) {
                this.CaseEvidenceType = CaseEvidenceType;
            }

            public SubImageListBean getSubImageList() {
                return SubImageList;
            }

            public void setSubImageList(SubImageListBean SubImageList) {
                this.SubImageList = SubImageList;
            }

            public static class SubImageListBean {
                private List<SubImageInfoObjectBean> SubImageInfoObject;

                public List<SubImageInfoObjectBean> getSubImageInfoObject() {
                    return SubImageInfoObject;
                }

                public void setSubImageInfoObject(List<SubImageInfoObjectBean> SubImageInfoObject) {
                    this.SubImageInfoObject = SubImageInfoObject;
                }

                public static class SubImageInfoObjectBean {
                    /**
                     * ImageID : 33020300001190000001022017122111111100021
                     * EventSort : 4
                     * DeviceID : 55220299011190000253
                     * StoragePath : http://localhost:9080/testx_108_20170908/a2421c4fde6d4a74ac923e8470d6e7fa.jpg
                     * Type : 13
                     * FileFormat : Jpeg
                     * ShotTime : 20170925032455
                     * Width : 437
                     * Height : 350
                     */

                    private String ImageID;
                    private int EventSort;
                    private String DeviceID;
                    private String StoragePath;
                    private String Type;
                    private String FileFormat;
                    private String ShotTime;
                    private int Width;
                    private int Height;

                    public String getImageID() {
                        return ImageID;
                    }

                    public void setImageID(String ImageID) {
                        this.ImageID = ImageID;
                    }

                    public int getEventSort() {
                        return EventSort;
                    }

                    public void setEventSort(int EventSort) {
                        this.EventSort = EventSort;
                    }

                    public String getDeviceID() {
                        return DeviceID;
                    }

                    public void setDeviceID(String DeviceID) {
                        this.DeviceID = DeviceID;
                    }

                    public String getStoragePath() {
                        return StoragePath;
                    }

                    public void setStoragePath(String StoragePath) {
                        this.StoragePath = StoragePath;
                    }

                    public String getType() {
                        return Type;
                    }

                    public void setType(String Type) {
                        this.Type = Type;
                    }

                    public String getFileFormat() {
                        return FileFormat;
                    }

                    public void setFileFormat(String FileFormat) {
                        this.FileFormat = FileFormat;
                    }

                    public String getShotTime() {
                        return ShotTime;
                    }

                    public void setShotTime(String ShotTime) {
                        this.ShotTime = ShotTime;
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
                }
            }
        }
    }
}
