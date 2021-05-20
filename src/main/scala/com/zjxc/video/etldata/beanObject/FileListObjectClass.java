package com.zjxc.video.etldata.beanObject;
/*
 *@ClassName  FileListObjectClass
 *@description    TODO
 *@author     Whoami
 *@date   2020/7/27
 *@version 1.0
 */

import java.util.List;

public class FileListObjectClass {

    /**
     * FileListObject : {"File":[{"PersonList":{},"FaceList":{},"MotorVehicleList":{},"NonMotorVehicleList":{},"ThingList":{},"SceneList":{},"FileInfo":{"FileID":"33010101001210000001032017093009520000031","InfoKind":2,"Source":"99","FileName":"测试","StoragePath":"http://10.33.6.108:9080/testx_108_20171212/063581a8801e4d46ac16962e75e20e53.txt","FileHash":"MDS2D33","FileFormat":"txt","Title":"测试标题","EntryTime":"20171001100000","FileSize":1024},"Data":"Base64编码"}]}
     */

    private FileListObjectBean FileListObject;

    public FileListObjectBean getFileListObject() {
        return FileListObject;
    }

    public void setFileListObject(FileListObjectBean FileListObject) {
        this.FileListObject = FileListObject;
    }

    public static class FileListObjectBean {
        private List<FileBean> File;

        public List<FileBean> getFile() {
            return File;
        }

        public void setFile(List<FileBean> File) {
            this.File = File;
        }

        public static class FileBean {
            /**
             * PersonList : {}
             * FaceList : {}
             * MotorVehicleList : {}
             * NonMotorVehicleList : {}
             * ThingList : {}
             * SceneList : {}
             * FileInfo : {"FileID":"33010101001210000001032017093009520000031","InfoKind":2,"Source":"99","FileName":"测试","StoragePath":"http://10.33.6.108:9080/testx_108_20171212/063581a8801e4d46ac16962e75e20e53.txt","FileHash":"MDS2D33","FileFormat":"txt","Title":"测试标题","EntryTime":"20171001100000","FileSize":1024}
             * Data : Base64编码
             */

            private PersonListBean PersonList;
            private FaceListBean FaceList;
            private MotorVehicleListBean MotorVehicleList;
            private NonMotorVehicleListBean NonMotorVehicleList;
            private ThingListBean ThingList;
            private SceneListBean SceneList;
            private FileInfoBean FileInfo;
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

            public FileInfoBean getFileInfo() {
                return FileInfo;
            }

            public void setFileInfo(FileInfoBean FileInfo) {
                this.FileInfo = FileInfo;
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

            public static class FileInfoBean {
                /**
                 * FileID : 33010101001210000001032017093009520000031
                 * InfoKind : 2
                 * Source : 99
                 * FileName : 测试
                 * StoragePath : http://10.33.6.108:9080/testx_108_20171212/063581a8801e4d46ac16962e75e20e53.txt
                 * FileHash : MDS2D33
                 * FileFormat : txt
                 * Title : 测试标题
                 * EntryTime : 20171001100000
                 * FileSize : 1024
                 */

                private String FileID;
                private int InfoKind;
                private String Source;
                private String FileName;
                private String StoragePath;
                private String FileHash;
                private String FileFormat;
                private String Title;
                private String EntryTime;
                private int FileSize;

                public String getFileID() {
                    return FileID;
                }

                public void setFileID(String FileID) {
                    this.FileID = FileID;
                }

                public int getInfoKind() {
                    return InfoKind;
                }

                public void setInfoKind(int InfoKind) {
                    this.InfoKind = InfoKind;
                }

                public String getSource() {
                    return Source;
                }

                public void setSource(String Source) {
                    this.Source = Source;
                }

                public String getFileName() {
                    return FileName;
                }

                public void setFileName(String FileName) {
                    this.FileName = FileName;
                }

                public String getStoragePath() {
                    return StoragePath;
                }

                public void setStoragePath(String StoragePath) {
                    this.StoragePath = StoragePath;
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
