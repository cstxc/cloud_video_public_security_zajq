package com.zjxc.video.etldata.beanObject;
/*
 *@ClassName  NonMotorVehicleListObjectClass
 *@description    TODO
 *@author     Whoami
 *@date   2020/7/10
 *@version 1.0
 */

import java.util.List;

public class NonMotorVehicleListObjectClass {

    /**
     * NonMotorVehicleListObject : {"NonMotorVehicleObject":[{"NonMotorVehicleID":"330101010012100000010220171018080608022060369856","InfoKind":1,"SourceID":"33010101001210000001022017101808060802206","DeviceID":"65010000001190000001","LeftTopX":4,"LeftTopY":2,"RightBtmX":21,"RightBtmY":23,"HasPlate":"1","PlateClass":"01","PlateColor":"2","PlateNo":"京A66666","PlateNoAttach":"312","PlateDescribe":"312","IsDecked":"1","IsAltered":"1","IsCovered":"1","DrivingStatusCode":"5","UsingPropertiesCode":"152","VehicleBrand":"2","VehicleType":"1","VehicleLength":12,"VehicleWidth":45,"VehicleHeight":45,"VehicleColor":"2","VehicleHood":"44","VehicleTrunk":"55","VehicleWheel":"33","WheelPrintedPattern":"2","VehicleWindow":"013","VehicleRoof":"1","VehicleDoor":"1","SideOfVehicle":"1","CarOfVehicle":"1","RearviewMirror":"1","VehicleChassis":"1","VehicleShielding":"1","FilmColor":"1","SubImageList":{"SubImageInfoObject":[{"ImageID":"33020300001190000001022017122111111100001","EventSort":4,"DeviceID":"55220299011190000253","StoragePath":"http://localhost:9080/testx_108_20170908/a2421c4fde6d4a74ac923e8470d6e7fa.jpg","Type":"01","FileFormat":"Jpeg","ShotTime":"20170925032455","Width":437,"Height":350}]}}]}
     */

    private NonMotorVehicleListObjectBean NonMotorVehicleListObject;

    public NonMotorVehicleListObjectBean getNonMotorVehicleListObject() {
        return NonMotorVehicleListObject;
    }

    public void setNonMotorVehicleListObject(NonMotorVehicleListObjectBean NonMotorVehicleListObject) {
        this.NonMotorVehicleListObject = NonMotorVehicleListObject;
    }

    public static class NonMotorVehicleListObjectBean {
        private List<NonMotorVehicleObjectBean> NonMotorVehicleObject;

        public List<NonMotorVehicleObjectBean> getNonMotorVehicleObject() {
            return NonMotorVehicleObject;
        }

        public void setNonMotorVehicleObject(List<NonMotorVehicleObjectBean> NonMotorVehicleObject) {
            this.NonMotorVehicleObject = NonMotorVehicleObject;
        }

        public static class NonMotorVehicleObjectBean {
            /**
             * NonMotorVehicleID : 330101010012100000010220171018080608022060369856
             * InfoKind : 1
             * SourceID : 33010101001210000001022017101808060802206
             * DeviceID : 65010000001190000001
             * LeftTopX : 4
             * LeftTopY : 2
             * RightBtmX : 21
             * RightBtmY : 23
             * HasPlate : 1
             * PlateClass : 01
             * PlateColor : 2
             * PlateNo : 京A66666
             * PlateNoAttach : 312
             * PlateDescribe : 312
             * IsDecked : 1
             * IsAltered : 1
             * IsCovered : 1
             * DrivingStatusCode : 5
             * UsingPropertiesCode : 152
             * VehicleBrand : 2
             * VehicleType : 1
             * VehicleLength : 12
             * VehicleWidth : 45
             * VehicleHeight : 45
             * VehicleColor : 2
             * VehicleHood : 44
             * VehicleTrunk : 55
             * VehicleWheel : 33
             * WheelPrintedPattern : 2
             * VehicleWindow : 013
             * VehicleRoof : 1
             * VehicleDoor : 1
             * SideOfVehicle : 1
             * CarOfVehicle : 1
             * RearviewMirror : 1
             * VehicleChassis : 1
             * VehicleShielding : 1
             * FilmColor : 1
             * SubImageList : {"SubImageInfoObject":[{"ImageID":"33020300001190000001022017122111111100001","EventSort":4,"DeviceID":"55220299011190000253","StoragePath":"http://localhost:9080/testx_108_20170908/a2421c4fde6d4a74ac923e8470d6e7fa.jpg","Type":"01","FileFormat":"Jpeg","ShotTime":"20170925032455","Width":437,"Height":350}]}
             */

            private String NonMotorVehicleID;
            private int InfoKind;
            private String SourceID;
            private String DeviceID;
            private int LeftTopX;
            private int LeftTopY;
            private int RightBtmX;
            private int RightBtmY;
            private String HasPlate;
            private String PlateClass;
            private String PlateColor;
            private String PlateNo;
            private String PlateNoAttach;
            private String PlateDescribe;
            private String IsDecked;
            private String IsAltered;
            private String IsCovered;
            private String DrivingStatusCode;
            private String UsingPropertiesCode;
            private String VehicleBrand;
            private String VehicleType;
            private int VehicleLength;
            private int VehicleWidth;
            private int VehicleHeight;
            private String VehicleColor;
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
            private SubImageListBean SubImageList;

            public String getNonMotorVehicleID() {
                return NonMotorVehicleID;
            }

            public void setNonMotorVehicleID(String NonMotorVehicleID) {
                this.NonMotorVehicleID = NonMotorVehicleID;
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

            public String getVehicleBrand() {
                return VehicleBrand;
            }

            public void setVehicleBrand(String VehicleBrand) {
                this.VehicleBrand = VehicleBrand;
            }

            public String getVehicleType() {
                return VehicleType;
            }

            public void setVehicleType(String VehicleType) {
                this.VehicleType = VehicleType;
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
