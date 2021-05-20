package com.zjxc.video.etldata.beanObject

import java.text.SimpleDateFormat
import java.util.Calendar

import com.zjxc.video.etldata.online.Utils.tUtils._
import cn.hutool.core.date.DateUtil
import com.alibaba.fastjson.JSON
import org.apache.hadoop.hbase.util.Bytes

import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import scala.collection.parallel.immutable

object JsonTest {
  def main(args: Array[String]): Unit = {
    val jo =
      """
        |{
        |   "FaceListObject": {
        |       "FaceObject": [
        |          {
        |               "FaceID": "650100000011900000010220171219100515999830656599",
        |               "InfoKind": 1,
        |               "SourceID": "66000000001190123456022017120110101000007",
        |               "DeviceID": "55000111221190000007",
        |               "LeftTopX": 1,
        |               "LeftTopY": 1,
        |               "RightBtmX": 1,
        |               "RightBtmY": 1,
        |               "LocationMarkTime": "19981230010000",
        |               "FaceAppearTime": "19981230010000",
        |               "FaceDisAppearTime": "19981230010000",
        |               "IDType": "111",
        |               "IDNumber": "1",
        |               "Name": "大华",
        |               "UsedName": "dahua",
        |               "Alias": "dahua",
        |               "GenderCode": "1",
        |               "AgeUpLimit": 10,
        |               "AgeLowerLimit": 20,
        |               "EthicCode": "01",
        |               "NationalityCode": "CHN",
        |               "NativeCityCode": "330108",
        |               "ResidenceAdminDivision": "330100",
        |               "ChineseAccentCode": "1",
        |               "JobCategory": "1",
        |               "AccompanyNumber": 1,
        |               "SkinColor": "1",
        |               "HairStyle": "1",
        |               "HairColor": "1",
        |               "FaceStyle": "1",
        |               "FacialFeature": "1",
        |               "PhysicalFeature": "1",
        |               "RespiratorColor": "1",
        |               "CapStyle": "1",
        |               "CapColor": "1",
        |               "GlassStyle": "1",
        |               "GlassColor": "1",
        |               "IsDriver": 1,
        |               "IsForeigner": 1,
        |               "PassportType": "1",
        |               "ImmigrantTypeCode": "1",
        |               "IsSuspectedTerrorist": 1,
        |               "SuspectedTerroristNumber": "1",
        |               "IsCriminalInvolved": 1,
        |               "CriminalInvolvedSpecilisationCode": "1",
        |               "BodySpeciallMark": "1",
        |               "CrimeMethod": "1",
        |               "CrimeCharacterCode": "111",
        |               "EscapedCriminalNumber": "11111111111111111111111",
        |               "IsDetainees": 1,
        |               "DetentionHouseCode": "111111111",
        |               "DetaineesIdentity": "1",
        |               "DetaineesSpecialIdentity": "1",
        |               "MemberTypeCode": "1",
        |               "IsVictim": 1,
        |               "VictimType": "1",
        |               "InjuredDegree": "1",
        |               "CorpseConditionCode": "1",
        |               "IsSuspiciousPerson": 1,
        |               "Attitude": 1,
        |               "Similaritydegree": 1,
        |               "EyebrowStyle": "1",
        |               "NoseStyle": "1",
        |               "MustacheStyle": "1",
        |               "LipStyle": "1",
        |               "WrinklePouch": "1",
        |               "AcneStain": "1",
        |               "FreckleBirthmark": "1",
        |               "ScarDimple": "1",
        |               "OtherFeature": "1",
        |               "SubImageList": {
        |                   "SubImageInfoObject": [
        |                      {
        |                           "ImageID": "33020300001190000001022017122111111100001",
        |                           "EventSort": 11,
        |                           "DeviceID": "33070299011190000253",
        |                           "StoragePath": "http://10.33.6.108:9080/testx_108_20170908/a2421c4fde6d4a74ac923e8470d6e7fa.jpg",
        |                           "Type": "01",
        |                           "FileFormat": "Jpeg",
        |                           "ShotTime": "20170825032455",
        |                           "Width": 437,
        |                           "Height": 350
        |                      }
        |                  ]
        |              }
        |          }
        |      ]
        |  }
        |}
        |""".stripMargin


    //    val personstr = "{\n    \"PersonListObject\": {\n        \"PersonObject\": [\n            {\n                \"PersonID\": \"650100000011900000010220171219100515999830156479\",\n                \"InfoKind\": 1,\n                \"SourceID\": \"66000000001190123456022017120110101000007\",\n                \"DeviceID\": \"55000111221190000007\",\n                \"LeftTopX\": 1,\n                \"LeftTopY\": 1,\n                \"RightBtmX\": 1,\n                \"RightBtmY\": 1,\n                \"LocationMarkTime\": \"19981230010000\",\n                \"PersonAppearTime\": \"19981230010000\",\n                \"PersonDisAppearTime\": \"19981230010000\",\n                \"IDType\": \"111\",\n                \"IDNumber\": \"1\",\n                \"Name\": \"大华\",\n                \"UsedName\": \"dahua\",\n                \"Alias\": \"dahua\",\n                \"GenderCode\": \"1\",\n                \"AgeUpLimit\": 10,\n                \"AgeLowerLimit\": 20,\n                \"EthicCode\": \"1\",\n                \"NationalityCode\": \"CHN\",\n                \"NativeCityCode\": \"330109\",\n                \"ResidenceAdminDivision\": \"330101\",\n                \"ChineseAccentCode\": \"2\",\n                \"PersonOrg\": \"浙江杭州\",\n                \"JobCategory\": \"2\",\n                \"AccompanyNumber\": 2,\n                \"HeightUpLimit\": 175,\n                \"HeightLowerLimit\": 130,\n                \"BodyType\": \"1\",\n                \"SkinColor\": \"1\",\n                \"HairStyle\": \"1\",\n                \"HairColor\": \"1\",\n                \"Gesture\": \"1\",\n                \"Status\": \"1\",\n                \"FaceStyle\": \"1\",\n                \"FacialFeature\": \"1\",\n                \"PhysicalFeature\": \"1\",\n                \"BodyFeature\": \"1\",\n                \"HabitualMovement\": \"1\",\n                \"Behavior\": \"1\",\n                \"BehaviorDescription\": \"走动\",\n                \"Appendant\": \"6\",\n                \"AppendantDescription\": \"眼镜磨碎\",\n                \"UmbrellaColor\": \"1\",\n                \"RespiratorColor\": \"1\",\n                \"CapStyle\": \"1\",\n                \"CapColor\": \"1\",\n                \"GlassStyle\": \"1\",\n                \"GlassColor\": \"1\",\n                \"ScarfColor\": \"1\",\n                \"BagStyle\": \"1\",\n                \"BagColor\": \"1\",\n                \"CoatStyle\": \"1\",\n                \"CoatLength\": \"2\",\n                \"CoatColor\": \"1\",\n                \"TrousersStyle\": \"1\",\n                \"TrousersColor\": \"1\",\n                \"TrousersLen\": \"2\",\n                \"ShoesStyle\": \"1\",\n                \"ShoesColor\": \"1\",\n                \"IsDriver\": 1,\n                \"IsForeigner\": 1,\n                \"PassportType\": \"99\",\n                \"ImmigrantTypeCode\": \"1\",\n                \"IsSuspectedTerrorist\": 1,\n                \"SuspectedTerroristNumber\": \"250\",\n                \"IsCriminalInvolved\": 1,\n                \"CriminalInvolvedSpecilisationCode\": \"1\",\n                \"BodySpeciallMark\": \"1\",\n                \"CrimeMethod\": \"1\",\n                \"CrimeCharacterCode\": \"285\",\n                \"EscapedCriminalNumber\": \"295\",\n                \"IsDetainees\": 1,\n                \"DetentionHouseCode\": \"520010000\",\n                \"DetaineesIdentity\": \"1\",\n                \"DetaineesSpecialIdentity\": \"1\",\n                \"MemberTypeCode\": \"1\",\n                \"IsVictim\": 1,\n                \"VictimType\": \"1\",\n                \"InjuredDegree\": \"1\",\n                \"CorpseConditionCode\": \"1\",\n                \"IsSuspiciousPerson\": 1,\n                \"SubImageList\": {\n                    \"SubImageInfoObject\": [\n                        {\n                            \"ImageID\": \"33020300001190000001022017122111111100011\",\n                            \"EventSort\": 11,\n                            \"DeviceID\": \"33070299011190000253\",\n                            \"StoragePath\": \"http://10.33.6.108:9080/testx_108_20170908/a2421c4fde6d4a74ac923e8470d6e7fa.jpg\",\n                            \"Type\": \"10\",\n                            \"FileFormat\": \"Jpeg\",\n                            \"ShotTime\": \"20170825032455\",\n                            \"Width\": 437,\n                            \"Height\": 350\n                        }\n                    ]\n                }\n            }\n        ]\n    }\n}"

    //    val image = "{\"imageListObject\":{\"image\":[{\"data\":null,\"faceList\":null,\"imageInfo\":{\"apertureValue\":null,\"cameraManufacturer\":null,\"cameraVersion\":null,\"collectorID\":null,\"collectorIDType\":null,\"collectorName\":null,\"collectorOrg\":null,\"contentDescription\":\"行人图片信息\",\"deviceID\":\"33010299011190000253\",\"entryClrk\":null,\"entryClrkID\":null,\"entryClrkIDType\":null,\"entryClrkOrg\":null,\"entryTime\":null,\"eventSort\":\"8\",\"fileFormat\":\"Jpeg\",\"fileHash\":null,\"fileSize\":null,\"focalLength\":null,\"height\":\"8192\",\"horizontalShotDirection\":null,\"iSOSensitivity\":null,\"imageID\":\"33010299011190000253022020062216293900000\",\"imageSource\":\"99\",\"imgProcFlag\":null,\"infoKind\":\"1\",\"keyWord\":null,\"originImageID\":null,\"qualityGrade\":null,\"securityLevel\":\"5\",\"shotPlaceCode\":null,\"shotPlaceFullAdress\":\"暂未支持\",\"shotPlaceLatitude\":null,\"shotPlaceLongitude\":null,\"shotTime\":1592814579000,\"sourceVideoID\":null,\"specialIName\":null,\"storagePath\":\"http://192.168.73.214:9000/minio/image/33010299011190000253022020062216293900000.png\",\"subjectCharacter\":null,\"title\":\"行人抓拍图片\",\"titleNote\":null,\"verticalShotDirection\":null,\"width\":\"8192\"},\"motorVehicleList\":null,\"nonMotorVehicleList\":null,\"personList\":{\"personListObject\":null},\"sceneList\":null,\"thingList\":null}]}}"
    //    val person = "{\"personListObject\":{\"personObject\":[{\"accompanyNumber\":null,\"ageLowerLimit\":null,\"ageUpLimit\":null,\"alias\":null,\"appendant\":null,\"appendantDescription\":null,\"bagColor\":null,\"bagStyle\":null,\"behavior\":null,\"behaviorDescription\":null,\"bodyFeature\":null,\"bodySpeciallMark\":null,\"bodyType\":null,\"capColor\":null,\"capStyle\":null,\"chineseAccentCode\":null,\"coatColor\":\"9\",\"coatLength\":\"2\",\"coatStyle\":null,\"corpseConditionCode\":null,\"crimeCharacterCode\":null,\"crimeMethod\":null,\"criminalInvolvedSpecilisationCode\":null,\"detaineesIdentity\":null,\"detaineesSpecialIdentity\":null,\"detentionHouseCode\":null,\"deviceID\":\"33010299011190000253\",\"escapedCriminalNumber\":null,\"ethicCode\":null,\"faceStyle\":null,\"facialFeature\":null,\"genderCode\":\"1\",\"gesture\":null,\"glassColor\":null,\"glassStyle\":null,\"habitualMovement\":null,\"hairColor\":null,\"hairStyle\":null,\"heightLowerLimit\":null,\"heightUpLimit\":null,\"iDNumber\":null,\"iDType\":null,\"immigrantTypeCode\":null,\"infoKind\":\"1\",\"injuredDegree\":null,\"isCriminalInvolved\":2,\"isDetainees\":2,\"isDriver\":2,\"isForeigner\":2,\"isSuspectedTerrorist\":2,\"isSuspiciousPerson\":2,\"isVictim\":2,\"jobCategory\":null,\"leftTopX\":1714,\"leftTopY\":688,\"locationMarkTime\":null,\"memberTypeCode\":null,\"name\":null,\"nationalityCode\":null,\"nativeCityCode\":null,\"passportType\":null,\"personAppearTime\":null,\"personDisAppearTime\":null,\"personID\":\"330102990111900002530220200622162939000000100001\",\"personOrg\":null,\"physicalFeature\":null,\"relatedList\":null,\"residenceAdminDivision\":null,\"respiratorColor\":null,\"rightBtmX\":1927,\"rightBtmY\":1011,\"scarfColor\":null,\"shoesColor\":null,\"shoesStyle\":null,\"skinColor\":null,\"sourceID\":\"33010299011190000253022020062216293900000\",\"status\":null,\"subImageList\":{\"subImageInfoObject\":[{\"data\":null,\"deviceID\":\"33010299011190000253\",\"eventSort\":\"8\",\"fileFormat\":\"Jpeg\",\"height\":\"1584\",\"imageID\":\"33010299011190000253022020062216293900000\",\"shotTime\":1592814579000,\"storagePath\":\"http://192.168.73.214:9000/minio/person/33010299011190000253022020062216293900000.png\",\"type\":\"14\",\"width\":\"2688\"},{\"data\":null,\"deviceID\":\"33010299011190000253\",\"eventSort\":\"8\",\"fileFormat\":\"Jpeg\",\"height\":\"322\",\"imageID\":\"33010299011190000253022020062216293900002\",\"shotTime\":1592814579000,\"storagePath\":\"http://192.168.73.214:9000/minio/person/33010299011190000253022020062216293900002.png\",\"type\":\"10\",\"width\":\"212\"}]},\"suspectedTerroristNumber\":null,\"trousersColor\":\"2\",\"trousersLen\":\"1\",\"trousersStyle\":null,\"umbrellaColor\":null,\"usedName\":null,\"victimType\":null}]}}"
    //    val face = "{\"FaceListObject\":{\"FaceObject\":[{\"FaceID\":\"330102990111900002540102202006221708270250602513\",\"InfoKind\":\"1\",\"SourceID\":\"33010299011190000254010220200622170827025\",\"DeviceID\":\"3301029901119000025401\",\"LeftTopX\":97,\"LeftTopY\":358,\"RightBtmX\":134,\"RightBtmY\":426,\"LocationMarkTime\":\"20200622170827\",\"FaceAppearTime\":\"20200622170827\",\"FaceDisAppearTime\":\"20200622170827\",\"IDType\":null,\"IDNumber\":null,\"Name\":null,\"UsedName\":null,\"Alias\":null,\"GenderCode\":\"0\",\"AgeUpLimit\":0,\"AgeLowerLimit\":0,\"EthicCode\":null,\"NationalityCode\":null,\"NativeCityCode\":null,\"ResidenceAdminDivision\":null,\"ChineseAccentCode\":null,\"JobCategory\":null,\"AccompanyNumber\":null,\"SkinColor\":null,\"HairStyle\":null,\"HairColor\":null,\"FaceStyle\":null,\"FacialFeature\":null,\"PhysicalFeature\":null,\"RespiratorColor\":null,\"CapStyle\":null,\"CapColor\":null,\"GlassStyle\":null,\"GlassColor\":null,\"IsDriver\":2,\"IsForeigner\":2,\"PassportType\":null,\"ImmigrantTypeCode\":null,\"IsSuspectedTerrorist\":2,\"SuspectedTerroristNumber\":null,\"IsCriminalInvolved\":2,\"CriminalInvolvedSpecilisationCode\":null,\"BodySpeciallMark\":null,\"CrimeMethod\":null,\"CrimeCharacterCode\":null,\"EscapedCriminalNumber\":null,\"IsDetainees\":2,\"DetentionHouseCode\":null,\"DetaineesIdentity\":null,\"DetaineesSpecialIdentity\":null,\"MemberTypeCode\":null,\"IsVictim\":2,\"VictimType\":null,\"InjuredDegree\":null,\"CorpseConditionCode\":null,\"IsSuspiciousPerson\":2,\"Attitude\":null,\"Similaritydegree\":null,\"EyebrowStyle\":null,\"NoseStyle\":null,\"MustacheStyle\":null,\"LipStyle\":null,\"WrinklePouch\":null,\"AcneStain\":null,\"FreckleBirthmark\":null,\"ScarDimple\":null,\"OtherFeature\":null,\"SubImageList\":{\"SubImageInfoObject\":[{\"ImageID\":\"33010299011190000254010220200622170827025\",\"EventSort\":\"10\",\"DeviceID\":\"3301029901119000025401\",\"StoragePath\":\"http://192.168.73.214:9000/minio/face/33010299011190000254010220200622170827025.png\",\"Type\":\"14\",\"FileFormat\":\"Jpeg\",\"ShotTime\":\"20200622170827\",\"Width\":\"1920\",\"Height\":\"1104\",\"Data\":null},{\"ImageID\":\"33010299011190000254010220200622170827025\",\"EventSort\":\"10\",\"DeviceID\":\"3301029901119000025401\",\"StoragePath\":\"http://192.168.73.214:9000/minio/face/33010299011190000254010220200622170827025.png\",\"Type\":\"11\",\"FileFormat\":\"Jpeg\",\"ShotTime\":\"20200622170827\",\"Width\":\"144\",\"Height\":\"196\",\"Data\":null}]}}]}}"
    //    val im = "{\"FaceListObject\":{\"FaceObject\":[{\"FaceID\":\"330102990111900002530220200618135738315600631561\",\"InfoKind\":\"1\",\"SourceID\":\"33010299011190000253022020061813573831560\",\"DeviceID\":\"33010299011190000253\",\"LeftTopX\":1537,\"LeftTopY\":740,\"RightBtmX\":1659,\"RightBtmY\":877,\"LocationMarkTime\":null,\"FaceAppearTime\":null,\"FaceDisAppearTime\":null,\"IDType\":null,\"IDNumber\":null,\"Name\":null,\"UsedName\":null,\"Alias\":null,\"GenderCode\":\"1\",\"AgeUpLimit\":29,\"AgeLowerLimit\":29,\"EthicCode\":null,\"NationalityCode\":null,\"NativeCityCode\":null,\"ResidenceAdminDivision\":null,\"ChineseAccentCode\":null,\"JobCategory\":null,\"AccompanyNumber\":null,\"SkinColor\":null,\"HairStyle\":null,\"HairColor\":null,\"FaceStyle\":null,\"FacialFeature\":null,\"PhysicalFeature\":null,\"RespiratorColor\":null,\"CapStyle\":null,\"CapColor\":null,\"GlassStyle\":\"99\",\"GlassColor\":null,\"IsDriver\":2,\"IsForeigner\":2,\"PassportType\":null,\"ImmigrantTypeCode\":null,\"IsSuspectedTerrorist\":2,\"SuspectedTerroristNumber\":null,\"IsCriminalInvolved\":2,\"CriminalInvolvedSpecilisationCode\":null,\"BodySpeciallMark\":null,\"CrimeMethod\":null,\"CrimeCharacterCode\":null,\"EscapedCriminalNumber\":null,\"IsDetainees\":2,\"DetentionHouseCode\":null,\"DetaineesIdentity\":null,\"DetaineesSpecialIdentity\":null,\"MemberTypeCode\":null,\"IsVictim\":2,\"VictimType\":null,\"InjuredDegree\":null,\"CorpseConditionCode\":null,\"IsSuspiciousPerson\":2,\"Attitude\":null,\"Similaritydegree\":null,\"EyebrowStyle\":null,\"NoseStyle\":null,\"MustacheStyle\":null,\"LipStyle\":null,\"WrinklePouch\":null,\"AcneStain\":null,\"FreckleBirthmark\":null,\"ScarDimple\":null,\"OtherFeature\":null,\"SubImageList\":{\"SubImageInfoObject\":[{\"ImageID\":\"33010299011190000253022020061813573831560\",\"EventSort\":\"10\",\"DeviceID\":\"33010299011190000253\",\"StoragePath\":\"http://192.168.33.12:9000/minio/test/33010299011190000253022020061813573831560.png\",\"Type\":\"14\",\"FileFormat\":\"Jpeg\",\"ShotTime\":\"20200618135738\",\"Width\":\"2688\",\"Height\":\"1584\",\"Data\":null},{\"ImageID\":\"33010299011190000253022020061813573831562\",\"EventSort\":\"10\",\"DeviceID\":\"33010299011190000253\",\"StoragePath\":\"http://192.168.33.12:9000/minio/test/33010299011190000253022020061813573831562.png\",\"Type\":\"11\",\"FileFormat\":\"Jpeg\",\"ShotTime\":\"20200618135738\",\"Width\":\"120\",\"Height\":\"136\",\"Data\":null}]}}]}}"
    //    val moto = "{\n    \"MotorVehicleListObject\": {\n        \"MotorVehicleObject\": [\n            {\n                \"MotorVehicleID\": \"330101010012100000010220171018080608022060269899\",\n                \"InfoKind\": 1,\n                \"SourceID\": \"33010101001210000001022017101808060802206\",\n                \"TollgateID\": \"2141245\",\n                \"DeviceID\": \"65010000001190000001\",\n                \"StorageUrl1\": \"9527/upload/122/20130901/00/0524-NAS221-50151415-AS.jpg\",\n                \"StorageUrl3\": \"3\",\n                \"StorageUrl5\": \"1\",\n                \"LeftTopX\": 1,\n                \"LeftTopY\": 2,\n                \"RightBtmX\": 3,\n                \"RightBtmY\": 4,\n                \"LaneNo\": 1,\n                \"HasPlate\": \"1\",\n                \"PlateClass\": \"99\",\n                \"PlateColor\": \"99\",\n                \"PlateNo\": \"苏NF5676\",\n                \"PlateNoAttach\": \"1\",\n                \"PlateDescribe\": \"12\",\n                \"IsDecked\": \"1\",\n                \"IsAltered\": \"1\",\n                \"IsCovered\": \"1\",\n                \"Speed\": 8,\n                \"Direction\": \"0\",\n                \"DrivingStatusCode\": \"1\",\n                \"UsingPropertiesCode\": \"1\",\n                \"VehicleClass\": \"1\",\n                \"VehicleBrand\": \"1\",\n                \"VehicleModel\": \"1\",\n                \"VehicleStyles\": \"12\",\n                \"VehicleLength\": 0,\n                \"VehicleWidth\": 23,\n                \"VehicleHeight\": 31,\n                \"VehicleColor\": \"1\",\n                \"VehicleColorDepth\": \"2\",\n                \"VehicleHood\": \"4\",\n                \"VehicleTrunk\": \"5\",\n                \"VehicleWheel\": \"1\",\n                \"WheelPrintedPattern\": \"1\",\n                \"VehicleWindow\": \"1\",\n                \"VehicleRoof\": \"1\",\n                \"VehicleDoor\": \"1\",\n                \"SideOfVehicle\": \"1\",\n                \"CarOfVehicle\": \"1\",\n                \"RearviewMirror\": \"1\",\n                \"VehicleChassis\": \"1\",\n                \"VehicleShielding\": \"1\",\n                \"FilmColor\": \"1\",\n                \"IsModified\": \"1\",\n                \"HitMarkInfo\": \"1\",\n                \"VehicleBodyDesc\": \"1\",\n                \"VehicleFrontItem\": \"1\",\n                \"DescOfFrontItem\": \"1\",\n                \"VehicleRearItem\": \"4\",\n                \"DescOfRearItem\": \"3\",\n                \"NumOfPassenger\": 2,\n                \"PassTime\": \"20160912220107\",\n                \"NameOfPassedRoad\": \"12\",\n                \"IsSuspicious\": \"1\",\n                \"PlateReliability\": \"1\",\n                \"PlateCharReliability\": \"苏-80,B-90,1-90,2-88,3-90,4-67,5-87\",\n                \"BrandReliability\": \"1\",\n                \"SubImageList\": {\n                    \"SubImageInfoObject\": [\n                        {\n                            \"ImageID\": \"33020300001190000001022017122111111100001\",\n                            \"EventSort\": 4,\n                            \"DeviceID\": \"55220299011190000253\",\n                            \"StoragePath\": \"http://localhost:9080/testx_108_20170908/a2421c4fde6d4a74ac923e8470d6e7fa.jpg\",\n                            \"Type\": \"01\",\n                            \"FileFormat\": \"Jpeg\",\n                            \"ShotTime\": \"20170925032455\",\n                            \"Width\": 437,\n                            \"Height\": 350\n                        }\n                    ]\n                }\n            }\n        ]\n    }\n}"
    //    val nomoto = "{\n    \"NonMotorVehicleListObject\": {\n        \"NonMotorVehicleObject\": [\n            {\n                \"NonMotorVehicleID\": \"330101010012100000010220171018080608022060369856\",\n                \"InfoKind\": 1,\n                \"SourceID\": \"33010101001210000001022017101808060802206\",\n                \"DeviceID\": \"65010000001190000001\",\n                \"LeftTopX\": 4,\n                \"LeftTopY\": 2,\n                \"RightBtmX\": 21,\n                \"RightBtmY\": 23,\n                \"HasPlate\": \"1\",\n                \"PlateClass\": \"01\",\n                \"PlateColor\": \"2\",\n                \"PlateNo\": \"京A66666\",\n                \"PlateNoAttach\": \"312\",\n                \"PlateDescribe\": \"312\",\n                \"IsDecked\": \"1\",\n                \"IsAltered\": \"1\",\n                \"IsCovered\": \"1\",\n                \"DrivingStatusCode\": \"5\",\n                \"UsingPropertiesCode\": \"152\",\n                \"VehicleBrand\": \"2\",\n                \"VehicleType\": \"1\",\n                \"VehicleLength\": 12,\n                \"VehicleWidth\": 45,\n                \"VehicleHeight\": 45,\n                \"VehicleColor\": \"2\",\n                \"VehicleHood\": \"44\",\n                \"VehicleTrunk\": \"55\",\n                \"VehicleWheel\": \"33\",\n                \"WheelPrintedPattern\": \"2\",\n                \"VehicleWindow\": \"013\",\n                \"VehicleRoof\": \"1\",\n                \"VehicleDoor\": \"1\",\n                \"SideOfVehicle\": \"1\",\n                \"CarOfVehicle\": \"1\",\n                \"RearviewMirror\": \"1\",\n                \"VehicleChassis\": \"1\",\n                \"VehicleShielding\": \"1\",\n                \"FilmColor\": \"1\",\n                \"SubImageList\": {\n                    \"SubImageInfoObject\": [\n                        {\n                            \"ImageID\": \"33020300001190000001022017122111111100001\",\n                            \"EventSort\": 4,\n                            \"DeviceID\": \"55220299011190000253\",\n                            \"StoragePath\": \"http://localhost:9080/testx_108_20170908/a2421c4fde6d4a74ac923e8470d6e7fa.jpg\",\n                            \"Type\": \"01\",\n                            \"FileFormat\": \"Jpeg\",\n                            \"ShotTime\": \"20170925032455\",\n                            \"Width\": 437,\n                            \"Height\": 350\n                        }\n                    ]\n                }\n            }\n        ]\n    }\n}"

    val str = "{\"FaceListObject\":{\"FaceObject\":[{\"acneStain\":null,\"serverId\":null,\"FaceID\":\"330102990111900002530220200720104144244890624490\",\"InfoKind\":1,\"SourceID\":\"33010299011190000253022020072010414424489\",\"DeviceID\":\"33010299011190000253\",\"LeftTopX\":347,\"LeftTopY\":429,\"RightBtmX\":541,\"RightBtmY\":618,\"LocationMarkTime\":null,\"FaceAppearTime\":null,\"FaceDisAppearTime\":null,\"IDType\":null,\"IDNumber\":null,\"Name\":null,\"UsedName\":null,\"Alias\":null,\"GenderCode\":\"1\",\"AgeUpLimit\":32,\"AgeLowerLimit\":32,\"EthicCode\":null,\"NationalityCode\":null,\"NativeCityCode\":null,\"ResidenceAdminDivision\":null,\"ChineseAccentCode\":null,\"JobCategory\":null,\"AccompanyNumber\":null,\"SkinColor\":null,\"HairStyle\":null,\"HairColor\":null,\"FaceStyle\":null,\"FacialFeature\":null,\"PhysicalFeature\":null,\"RespiratorColor\":null,\"CapStyle\":null,\"CapColor\":null,\"GlassStyle\":\"99\",\"GlassColor\":null,\"IsDriver\":2,\"IsForeigner\":2,\"PassportType\":null,\"ImmigrantTypeCode\":null,\"IsSuspectedTerrorist\":2,\"SuspectedTerroristNumber\":null,\"IsCriminalInvolved\":2,\"CriminalInvolvedSpecilisationCode\":null,\"BodySpeciallMark\":null,\"CrimeMethod\":null,\"CrimeCharacterCode\":null,\"EscapedCriminalNumber\":null,\"IsDetainees\":2,\"DetentionHouseCode\":null,\"DetaineesIdentity\":null,\"DetaineesSpecialIdentity\":null,\"MemberTypeCode\":null,\"IsVictim\":2,\"VictimType\":null,\"InjuredDegree\":null,\"CorpseConditionCode\":null,\"IsSuspiciousPerson\":2,\"Attitude\":null,\"Similaritydegree\":null,\"EyebrowStyle\":null,\"NoseStyle\":null,\"MustacheStyle\":null,\"LipStyle\":null,\"WrinklePouch\":null,\"FreckleBirthmark\":null,\"ScarDimple\":null,\"OtherFeature\":null,\"SubImageList\":{\"SubImageInfoObject\":[{\"ImageID\":\"33010299011190000253022020072010414424489\",\"EventSort\":\"10\",\"DeviceID\":\"33010299011190000253\",\"StoragePath\":\"http://122.224.82.76:9000/face/3301029901119000025302202007201041442448914.png\",\"Type\":\"14\",\"FileFormat\":\"Jpeg\",\"ShotTime\":\"20200720104144\",\"Width\":\"2688\",\"Height\":\"1584\",\"Data\":null}]}}]}}"

    //    println("personListMessagePooldb".toLowerCase())
    //    println(parseJsonImageListToArrayBuffer(image))
    //    println(parseJsonDistinguish(face))
    //    println(parseJsonDistinguish(str))


    //    println(parseJsonDistinguish(str))

    println(Bytes.toBytes("\\x00"))



    //    val start = "20200501"
    //    val end   = "20200724"

    //   val daterang = getBetweenDates(start,end).foreach(x=>{
    //      println("select  REVERSE(SUBSTR(\"num\",0,6)) date,count(1) \"count\" from \"alertData\" where  \"num\" like  '" + x.substring(2,8).reverse + "' group by SUBSTR(\"num\",0,6) union all")
    //    })


    //        val today = DateUtil.today().replace("-","").substring(2,8).reverse
    //        println(today)
    //
    //    val yestoday = DateUtil.yesterday().toString.substring(0,10).replace("-","").substring(2,8).reverse
    //    println(yestoday)


  }

  def getBetweenDates(start: String, end: String) = {
    val startData = new SimpleDateFormat("yyyyMMdd").parse(start); //定义起始日期
    val endData = new SimpleDateFormat("yyyyMMdd").parse(end); //定义结束日期

    val dateFormat: SimpleDateFormat = new SimpleDateFormat("yyyyMMdd")
    var buffer = new ListBuffer[String]
    buffer += dateFormat.format(startData.getTime())
    val tempStart = Calendar.getInstance()

    tempStart.setTime(startData)
    tempStart.add(Calendar.DAY_OF_YEAR, 1)

    val tempEnd = Calendar.getInstance()
    tempEnd.setTime(endData)
    while (tempStart.before(tempEnd)) {
      // result.add(dateFormat.format(tempStart.getTime()))
      buffer += dateFormat.format(tempStart.getTime())
      tempStart.add(Calendar.DAY_OF_YEAR, 1)
    }
    buffer += dateFormat.format(endData.getTime())
    buffer.toList
  }


  //ZA_FaceCaptureListObject
  def parseJsonZA_FaceCaptureListObjectToArrayBuffer(string: String) = {
    val po = JSON.parseObject(string, classOf[ZA_FaceCaptureListObjectClass])
    try {
      ArrayBuffer(
        po.getFaceCaptureList.getFaceCaptureObject.get(0).getRLZPXXBZ + "",
        string + "",
        "ZA_FaceCaptureListMessagePooldb",
        po.getFaceCaptureList.getFaceCaptureObject.get(0).getCJSJ + "",
        po.getFaceCaptureList.getFaceCaptureObject.get(0).isHit.toString + "",
        po.getFaceCaptureList.getFaceCaptureObject.get(0).getSFJSY_PDBZ + "",
        po.getFaceCaptureList.getFaceCaptureObject.get(0).getBrard.toString + "",
        po.getFaceCaptureList.getFaceCaptureObject.get(0).getXBDM.toString + "",
        po.getFaceCaptureList.getFaceCaptureObject.get(0).getBeginTime.toString + "",
        po.getFaceCaptureList.getFaceCaptureObject.get(0).getChannelCode + "",
        po.getFaceCaptureList.getFaceCaptureObject.get(0).getMask.toString + "",
        po.getFaceCaptureList.getFaceCaptureObject.get(0).getSFGZRY_PDBZ + "",
        po.getFaceCaptureList.getFaceCaptureObject.get(0).getSPTXXXYYSXDXBZ + "",
        po.getFaceCaptureList.getFaceCaptureObject.get(0).getCJSBXXBZ + "",
        po.getFaceCaptureList.getFaceCaptureObject.get(0).getSY_YS + "",
        po.getFaceCaptureList.getFaceCaptureObject.get(0).getOccurrenceCount.toString + "",
        po.getFaceCaptureList.getFaceCaptureObject.get(0).getGlobalScenePicUrl + "",
        po.getFaceCaptureList.getFaceCaptureObject.get(0).getEye.toString + "",
        po.getFaceCaptureList.getFaceCaptureObject.get(0).getMouth.toString + "",
        po.getFaceCaptureList.getFaceCaptureObject.get(0).getFaceImgUrl + "",
        po.getFaceCaptureList.getFaceCaptureObject.get(0).getXZ_YS + "",
        po.getFaceCaptureList.getFaceCaptureObject.get(0).getChannelSeq.toString + "",
        po.getFaceCaptureList.getFaceCaptureObject.get(0).getRLCJT_URL + "",
        po.getFaceCaptureList.getFaceCaptureObject.get(0).getEndTime.toString + "",
        po.getFaceCaptureList.getFaceCaptureObject.get(0).getTP + "",
        po.getFaceCaptureList.getFaceCaptureObject.get(0).getAge.toString + "",
        po.getFaceCaptureList.getFaceCaptureObject.get(0).getSFBKRY_PDBZ + ""
      )
    } catch {
      case e: Throwable => println(" parse error .. " + e.getMessage)
        null
    }
  }

  //ZA_MotorVehicleEventListObiect
  def parseJsonZA_MotorVehicleEventListObjectToArrayBuffer(string: String) = {
    val po = JSON.parseObject(string, classOf[ZA_MotorVehicleEventListObiectClass])
    try {
      ArrayBuffer(

        po.getMotorVehicleEventList.getMotorVehicleEventObject.get(0).getJDCGCXXBZ.toString + "",
        string + "",
        "ZA_MotorVehicleEventListMessagePooldb",
        po.getMotorVehicleEventList.getMotorVehicleEventObject.get(0).getCJSJ + "",
        po.getMotorVehicleEventList.getMotorVehicleEventObject.get(0).getCarWayCode + "",
        po.getMotorVehicleEventList.getMotorVehicleEventObject.get(0).getDevId + "",
        po.getMotorVehicleEventList.getMotorVehicleEventObject.get(0).getCLQJTXBZ + "",
        po.getMotorVehicleEventList.getMotorVehicleEventObject.get(0).getCLXH.toString + "",
        po.getMotorVehicleEventList.getMotorVehicleEventObject.get(0).getJDCCLLXDM + "",
        po.getMotorVehicleEventList.getMotorVehicleEventObject.get(0).getCJSBXXBZ + "",
        po.getMotorVehicleEventList.getMotorVehicleEventObject.get(0).getSFWZDCL_PDBZ + "",
        po.getMotorVehicleEventList.getMotorVehicleEventObject.get(0).getJDCHPZLDM + "",
        po.getMotorVehicleEventList.getMotorVehicleEventObject.get(0).getDevName + "",
        po.getMotorVehicleEventList.getMotorVehicleEventObject.get(0).getIsMotorVehicleReg.toString + "",
        po.getMotorVehicleEventList.getMotorVehicleEventObject.get(0).getGCFX.toString + "",
        po.getMotorVehicleEventList.getMotorVehicleEventObject.get(0).getCarImgUrl + "",
        po.getMotorVehicleEventList.getMotorVehicleEventObject.get(0).getJDCHPYSDM + "",
        po.getMotorVehicleEventList.getMotorVehicleEventObject.get(0).getCarNumPic + "",
        po.getMotorVehicleEventList.getMotorVehicleEventObject.get(0).getJDCCSYSDM + "",
        po.getMotorVehicleEventList.getMotorVehicleEventObject.get(0).getDevChnName + "",
        po.getMotorVehicleEventList.getMotorVehicleEventObject.get(0).getCLHPTXBZ + "",
        po.getMotorVehicleEventList.getMotorVehicleEventObject.get(0).getJDCHPHM + ""
      )
    } catch {
      case e: Throwable => println(" parse error .. " + e.getMessage)
        null
    }
  }


}
