package com.zjxc.video.etldata.beanObject;/*
 *@ClassName  MotorVehicleListObject
 *@description    TODO
 *@author     Whoami
 *@date   2020/7/9
 *@version 1.0
 */

import java.util.List;

public class MotorVehicleListObjectClass {

    /**
     * MotorVehicleListObject : {"MotorVehicleObject":[{"MotorVehicleID":"330101010012100000010220171018080608022060269899","InfoKind":1,"SourceID":"33010101001210000001022017101808060802206","TollgateID":"2141245","DeviceID":"65010000001190000001","StorageUrl1":"9527/upload/122/20130901/00/0524-NAS221-50151415-AS.jpg","StorageUrl3":"3","StorageUrl5":"1","LeftTopX":1,"LeftTopY":2,"RightBtmX":3,"RightBtmY":4,"LaneNo":1,"HasPlate":"1","PlateClass":"99","PlateColor":"99","PlateNo":"苏NF5676","PlateNoAttach":"1","PlateDescribe":"12","IsDecked":"1","IsAltered":"1","IsCovered":"1","Speed":8,"Direction":"0","DrivingStatusCode":"1","UsingPropertiesCode":"1","VehicleClass":"1","VehicleBrand":"1","VehicleModel":"1","VehicleStyles":"12","VehicleLength":0,"VehicleWidth":23,"VehicleHeight":31,"VehicleColor":"1","VehicleColorDepth":"2","VehicleHood":"4","VehicleTrunk":"5","VehicleWheel":"1","WheelPrintedPattern":"1","VehicleWindow":"1","VehicleRoof":"1","VehicleDoor":"1","SideOfVehicle":"1","CarOfVehicle":"1","RearviewMirror":"1","VehicleChassis":"1","VehicleShielding":"1","FilmColor":"1","IsModified":"1","HitMarkInfo":"1","VehicleBodyDesc":"1","VehicleFrontItem":"1","DescOfFrontItem":"1","VehicleRearItem":"4","DescOfRearItem":"3","NumOfPassenger":2,"PassTime":"20160912220107","NameOfPassedRoad":"12","IsSuspicious":"1","PlateReliability":"1","PlateCharReliability":"苏-80,B-90,1-90,2-88,3-90,4-67,5-87","BrandReliability":"1","SubImageList":{"SubImageInfoObject":[{"ImageID":"33020300001190000001022017122111111100001","EventSort":4,"DeviceID":"55220299011190000253","StoragePath":"http://localhost:9080/testx_108_20170908/a2421c4fde6d4a74ac923e8470d6e7fa.jpg","Type":"01","FileFormat":"Jpeg","ShotTime":"20170925032455","Width":437,"Height":350}]}}]}
     */

    private MotorVehicleListObjectBean MotorVehicleListObject;

    public MotorVehicleListObjectBean getMotorVehicleListObject() {
        return MotorVehicleListObject;
    }

    public void setMotorVehicleListObject(MotorVehicleListObjectBean MotorVehicleListObject) {
        this.MotorVehicleListObject = MotorVehicleListObject;
    }

    public static class MotorVehicleListObjectBean {
        private List<MotorVehicleObjectBean> MotorVehicleObject;

        public List<MotorVehicleObjectBean> getMotorVehicleObject() {
            return MotorVehicleObject;
        }

        public void setMotorVehicleObject(List<MotorVehicleObjectBean> MotorVehicleObject) {
            this.MotorVehicleObject = MotorVehicleObject;
        }

        public static class MotorVehicleObjectBean {
            /**
             * MotorVehicleID : 330101010012100000010220171018080608022060269899
             * InfoKind : 1
             * SourceID : 33010101001210000001022017101808060802206
             * TollgateID : 2141245
             * DeviceID : 65010000001190000001
             * StorageUrl1 : 9527/upload/122/20130901/00/0524-NAS221-50151415-AS.jpg
             * StorageUrl3 : 3
             * StorageUrl5 : 1
             * LeftTopX : 1
             * LeftTopY : 2
             * RightBtmX : 3
             * RightBtmY : 4
             * LaneNo : 1
             * HasPlate : 1
             * PlateClass : 99
             * PlateColor : 99
             * PlateNo : 苏NF5676
             * PlateNoAttach : 1
             * PlateDescribe : 12
             * IsDecked : 1
             * IsAltered : 1
             * IsCovered : 1
             * Speed : 8
             * Direction : 0
             * DrivingStatusCode : 1
             * UsingPropertiesCode : 1
             * VehicleClass : 1
             * VehicleBrand : 1
             * VehicleModel : 1
             * VehicleStyles : 12
             * VehicleLength : 0
             * VehicleWidth : 23
             * VehicleHeight : 31
             * VehicleColor : 1
             * VehicleColorDepth : 2
             * VehicleHood : 4
             * VehicleTrunk : 5
             * VehicleWheel : 1
             * WheelPrintedPattern : 1
             * VehicleWindow : 1
             * VehicleRoof : 1
             * VehicleDoor : 1
             * SideOfVehicle : 1
             * CarOfVehicle : 1
             * RearviewMirror : 1
             * VehicleChassis : 1
             * VehicleShielding : 1
             * FilmColor : 1
             * IsModified : 1
             * HitMarkInfo : 1
             * VehicleBodyDesc : 1
             * VehicleFrontItem : 1
             * DescOfFrontItem : 1
             * VehicleRearItem : 4
             * DescOfRearItem : 3
             * NumOfPassenger : 2
             * PassTime : 20160912220107
             * NameOfPassedRoad : 12
             * IsSuspicious : 1
             * PlateReliability : 1
             * PlateCharReliability : 苏-80,B-90,1-90,2-88,3-90,4-67,5-87
             * BrandReliability : 1
             * SubImageList : {"SubImageInfoObject":[{"ImageID":"33020300001190000001022017122111111100001","EventSort":4,"DeviceID":"55220299011190000253","StoragePath":"http://localhost:9080/testx_108_20170908/a2421c4fde6d4a74ac923e8470d6e7fa.jpg","Type":"01","FileFormat":"Jpeg","ShotTime":"20170925032455","Width":437,"Height":350}]}
             */

            private String MotorVehicleID;
            private int InfoKind;
            private String SourceID;
            private String TollgateID;
            private String DeviceID;
            private String StorageUrl1;
            private String StorageUrl3;
            private String StorageUrl5;
            private int LeftTopX;
            private int LeftTopY;
            private int RightBtmX;
            private int RightBtmY;
            private int LaneNo;
            private String HasPlate;
            private String PlateClass;
            private String PlateColor;
            private String PlateNo;
            private String PlateNoAttach;
            private String PlateDescribe;
            private String IsDecked;
            private String IsAltered;
            private String IsCovered;
            private int Speed;
            private String Direction;
            private String DrivingStatusCode;
            private String UsingPropertiesCode;
            private String VehicleClass;
            private String VehicleBrand;
            private String VehicleModel;
            private String VehicleStyles;
            private int VehicleLength;
            private int VehicleWidth;
            private int VehicleHeight;
            private String VehicleColor;
            private String VehicleColorDepth;
            private String VehicleHood;
            private String VehicleTrunk;
            private String VehicleWheel;
            private String WheelPrintedPattern;
            private String VehicleWindow;
            private String VehicleRoof;
            private String VehicleDoor;
            private String SideOfVehicle;
            private String CarOfVehicle;
            private String RearviewMirror;
            private String VehicleChassis;
            private String VehicleShielding;
            private String FilmColor;
            private String IsModified;
            private String HitMarkInfo;
            private String VehicleBodyDesc;
            private String VehicleFrontItem;
            private String DescOfFrontItem;
            private String VehicleRearItem;
            private String DescOfRearItem;
            private int NumOfPassenger;
            private String PassTime;
            private String NameOfPassedRoad;
            private String IsSuspicious;
            private String PlateReliability;
            private String PlateCharReliability;
            private String BrandReliability;
            private SubImageListBean SubImageList;

            public String getMotorVehicleID() {
                return MotorVehicleID;
            }

            public void setMotorVehicleID(String MotorVehicleID) {
                this.MotorVehicleID = MotorVehicleID;
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

            public String getTollgateID() {
                return TollgateID;
            }

            public void setTollgateID(String TollgateID) {
                this.TollgateID = TollgateID;
            }

            public String getDeviceID() {
                return DeviceID;
            }

            public void setDeviceID(String DeviceID) {
                this.DeviceID = DeviceID;
            }

            public String getStorageUrl1() {
                return StorageUrl1;
            }

            public void setStorageUrl1(String StorageUrl1) {
                this.StorageUrl1 = StorageUrl1;
            }

            public String getStorageUrl3() {
                return StorageUrl3;
            }

            public void setStorageUrl3(String StorageUrl3) {
                this.StorageUrl3 = StorageUrl3;
            }

            public String getStorageUrl5() {
                return StorageUrl5;
            }

            public void setStorageUrl5(String StorageUrl5) {
                this.StorageUrl5 = StorageUrl5;
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

            public int getLaneNo() {
                return LaneNo;
            }

            public void setLaneNo(int LaneNo) {
                this.LaneNo = LaneNo;
            }

            public String getHasPlate() {
                return HasPlate;
            }

            public void setHasPlate(String HasPlate) {
                this.HasPlate = HasPlate;
            }

            public String getPlateClass() {
                return PlateClass;
            }

            public void setPlateClass(String PlateClass) {
                this.PlateClass = PlateClass;
            }

            public String getPlateColor() {
                return PlateColor;
            }

            public void setPlateColor(String PlateColor) {
                this.PlateColor = PlateColor;
            }

            public String getPlateNo() {
                return PlateNo;
            }

            public void setPlateNo(String PlateNo) {
                this.PlateNo = PlateNo;
            }

            public String getPlateNoAttach() {
                return PlateNoAttach;
            }

            public void setPlateNoAttach(String PlateNoAttach) {
                this.PlateNoAttach = PlateNoAttach;
            }

            public String getPlateDescribe() {
                return PlateDescribe;
            }

            public void setPlateDescribe(String PlateDescribe) {
                this.PlateDescribe = PlateDescribe;
            }

            public String getIsDecked() {
                return IsDecked;
            }

            public void setIsDecked(String IsDecked) {
                this.IsDecked = IsDecked;
            }

            public String getIsAltered() {
                return IsAltered;
            }

            public void setIsAltered(String IsAltered) {
                this.IsAltered = IsAltered;
            }

            public String getIsCovered() {
                return IsCovered;
            }

            public void setIsCovered(String IsCovered) {
                this.IsCovered = IsCovered;
            }

            public int getSpeed() {
                return Speed;
            }

            public void setSpeed(int Speed) {
                this.Speed = Speed;
            }

            public String getDirection() {
                return Direction;
            }

            public void setDirection(String Direction) {
                this.Direction = Direction;
            }

            public String getDrivingStatusCode() {
                return DrivingStatusCode;
            }

            public void setDrivingStatusCode(String DrivingStatusCode) {
                this.DrivingStatusCode = DrivingStatusCode;
            }

            public String getUsingPropertiesCode() {
                return UsingPropertiesCode;
            }

            public void setUsingPropertiesCode(String UsingPropertiesCode) {
                this.UsingPropertiesCode = UsingPropertiesCode;
            }

            public String getVehicleClass() {
                return VehicleClass;
            }

            public void setVehicleClass(String VehicleClass) {
                this.VehicleClass = VehicleClass;
            }

            public String getVehicleBrand() {
                return VehicleBrand;
            }

            public void setVehicleBrand(String VehicleBrand) {
                this.VehicleBrand = VehicleBrand;
            }

            public String getVehicleModel() {
                return VehicleModel;
            }

            public void setVehicleModel(String VehicleModel) {
                this.VehicleModel = VehicleModel;
            }

            public String getVehicleStyles() {
                return VehicleStyles;
            }

            public void setVehicleStyles(String VehicleStyles) {
                this.VehicleStyles = VehicleStyles;
            }

            public int getVehicleLength() {
                return VehicleLength;
            }

            public void setVehicleLength(int VehicleLength) {
                this.VehicleLength = VehicleLength;
            }

            public int getVehicleWidth() {
                return VehicleWidth;
            }

            public void setVehicleWidth(int VehicleWidth) {
                this.VehicleWidth = VehicleWidth;
            }

            public int getVehicleHeight() {
                return VehicleHeight;
            }

            public void setVehicleHeight(int VehicleHeight) {
                this.VehicleHeight = VehicleHeight;
            }

            public String getVehicleColor() {
                return VehicleColor;
            }

            public void setVehicleColor(String VehicleColor) {
                this.VehicleColor = VehicleColor;
            }

            public String getVehicleColorDepth() {
                return VehicleColorDepth;
            }

            public void setVehicleColorDepth(String VehicleColorDepth) {
                this.VehicleColorDepth = VehicleColorDepth;
            }

            public String getVehicleHood() {
                return VehicleHood;
            }

            public void setVehicleHood(String VehicleHood) {
                this.VehicleHood = VehicleHood;
            }

            public String getVehicleTrunk() {
                return VehicleTrunk;
            }

            public void setVehicleTrunk(String VehicleTrunk) {
                this.VehicleTrunk = VehicleTrunk;
            }

            public String getVehicleWheel() {
                return VehicleWheel;
            }

            public void setVehicleWheel(String VehicleWheel) {
                this.VehicleWheel = VehicleWheel;
            }

            public String getWheelPrintedPattern() {
                return WheelPrintedPattern;
            }

            public void setWheelPrintedPattern(String WheelPrintedPattern) {
                this.WheelPrintedPattern = WheelPrintedPattern;
            }

            public String getVehicleWindow() {
                return VehicleWindow;
            }

            public void setVehicleWindow(String VehicleWindow) {
                this.VehicleWindow = VehicleWindow;
            }

            public String getVehicleRoof() {
                return VehicleRoof;
            }

            public void setVehicleRoof(String VehicleRoof) {
                this.VehicleRoof = VehicleRoof;
            }

            public String getVehicleDoor() {
                return VehicleDoor;
            }

            public void setVehicleDoor(String VehicleDoor) {
                this.VehicleDoor = VehicleDoor;
            }

            public String getSideOfVehicle() {
                return SideOfVehicle;
            }

            public void setSideOfVehicle(String SideOfVehicle) {
                this.SideOfVehicle = SideOfVehicle;
            }

            public String getCarOfVehicle() {
                return CarOfVehicle;
            }

            public void setCarOfVehicle(String CarOfVehicle) {
                this.CarOfVehicle = CarOfVehicle;
            }

            public String getRearviewMirror() {
                return RearviewMirror;
            }

            public void setRearviewMirror(String RearviewMirror) {
                this.RearviewMirror = RearviewMirror;
            }

            public String getVehicleChassis() {
                return VehicleChassis;
            }

            public void setVehicleChassis(String VehicleChassis) {
                this.VehicleChassis = VehicleChassis;
            }

            public String getVehicleShielding() {
                return VehicleShielding;
            }

            public void setVehicleShielding(String VehicleShielding) {
                this.VehicleShielding = VehicleShielding;
            }

            public String getFilmColor() {
                return FilmColor;
            }

            public void setFilmColor(String FilmColor) {
                this.FilmColor = FilmColor;
            }

            public String getIsModified() {
                return IsModified;
            }

            public void setIsModified(String IsModified) {
                this.IsModified = IsModified;
            }

            public String getHitMarkInfo() {
                return HitMarkInfo;
            }

            public void setHitMarkInfo(String HitMarkInfo) {
                this.HitMarkInfo = HitMarkInfo;
            }

            public String getVehicleBodyDesc() {
                return VehicleBodyDesc;
            }

            public void setVehicleBodyDesc(String VehicleBodyDesc) {
                this.VehicleBodyDesc = VehicleBodyDesc;
            }

            public String getVehicleFrontItem() {
                return VehicleFrontItem;
            }

            public void setVehicleFrontItem(String VehicleFrontItem) {
                this.VehicleFrontItem = VehicleFrontItem;
            }

            public String getDescOfFrontItem() {
                return DescOfFrontItem;
            }

            public void setDescOfFrontItem(String DescOfFrontItem) {
                this.DescOfFrontItem = DescOfFrontItem;
            }

            public String getVehicleRearItem() {
                return VehicleRearItem;
            }

            public void setVehicleRearItem(String VehicleRearItem) {
                this.VehicleRearItem = VehicleRearItem;
            }

            public String getDescOfRearItem() {
                return DescOfRearItem;
            }

            public void setDescOfRearItem(String DescOfRearItem) {
                this.DescOfRearItem = DescOfRearItem;
            }

            public int getNumOfPassenger() {
                return NumOfPassenger;
            }

            public void setNumOfPassenger(int NumOfPassenger) {
                this.NumOfPassenger = NumOfPassenger;
            }

            public String getPassTime() {
                return PassTime;
            }

            public void setPassTime(String PassTime) {
                this.PassTime = PassTime;
            }

            public String getNameOfPassedRoad() {
                return NameOfPassedRoad;
            }

            public void setNameOfPassedRoad(String NameOfPassedRoad) {
                this.NameOfPassedRoad = NameOfPassedRoad;
            }

            public String getIsSuspicious() {
                return IsSuspicious;
            }

            public void setIsSuspicious(String IsSuspicious) {
                this.IsSuspicious = IsSuspicious;
            }

            public String getPlateReliability() {
                return PlateReliability;
            }

            public void setPlateReliability(String PlateReliability) {
                this.PlateReliability = PlateReliability;
            }

            public String getPlateCharReliability() {
                return PlateCharReliability;
            }

            public void setPlateCharReliability(String PlateCharReliability) {
                this.PlateCharReliability = PlateCharReliability;
            }

            public String getBrandReliability() {
                return BrandReliability;
            }

            public void setBrandReliability(String BrandReliability) {
                this.BrandReliability = BrandReliability;
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
                     * ImageID : 33020300001190000001022017122111111100001
                     * EventSort : 4
                     * DeviceID : 55220299011190000253
                     * StoragePath : http://localhost:9080/testx_108_20170908/a2421c4fde6d4a74ac923e8470d6e7fa.jpg
                     * Type : 01
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

