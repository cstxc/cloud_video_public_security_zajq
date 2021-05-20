package com.zjxc.video.etldata.online.Utils

import java.util.UUID

import cn.hutool.Hutool
import cn.hutool.core.date.DateTime
import com.alibaba.fastjson.{JSON, JSONObject}
import com.zjxc.video.etldata.beanObject._
import org.apache.commons.lang3.StringUtils
import redis.clients.jedis.Jedis

import scala.collection.mutable.ArrayBuffer

/*
 ***********
               ***** ***********
            ** ****** *** ********
           ***   ******  ** *******
           ***     *******    ******
           ***                 *  **
            *|/------  -------\ ** *
             |       |=|       :===**
              |  O  |   | O   |  }|*
               |---- |   ----  |  |*
               |    |___       |\/
               |              |
               \   -----     |
                \           |
                  -__ -- -/
*/

object tUtils {

  //todo:redis累加的方法


  def hincrByRedis(jedis: Jedis, device: String): Unit = {
    val today = DateTime.now().toDateStr.replace("-", "")

    //可做分时
    //val timeHour = "_" + new SimpleDateFormat("HH").format(new Date)

    //总数加1
    jedis.hincrBy("all_count", today, 1)


    //设备计数
    jedis.hincrBy("all_count_device", today + '_' + device, 1)

    //本当の技術を示す時が来た

  }


  //数据分流
  def parseJsonDistinguish(string: String) = {

    val poFace = try {
      JSON.parseObject(string, classOf[FaceListObjectClass]).getFaceListObject.getFaceObject.get(0).getFaceID
    } catch {
      case e: Exception => "null"
    }

    val poImage = try {
      JSON.parseObject(string, classOf[ImageListObjectClass]).getImageListObject.getImage.get(0).getImageInfo.getImageID
    } catch {
      case e: Exception => "null"
    }

    val poPerson = try {
      JSON.parseObject(string, classOf[PersonListObjectClass]).getPersonListObject.getPersonObject.get(0).getPersonID
    } catch {
      case e: Exception => "null"
    }

    val poMoto = try {
      JSON.parseObject(string, classOf[MotorVehicleListObjectClass]).getMotorVehicleListObject.getMotorVehicleObject.get(0).getMotorVehicleID
    } catch {
      case e: Exception => "null"
    }

    val poNoMoto = try {
      JSON.parseObject(string, classOf[NonMotorVehicleListObjectClass]).getNonMotorVehicleListObject.getNonMotorVehicleObject.get(0).getNonMotorVehicleID
    } catch {
      case e: Exception => "null"
    }

    val poThing = try {
      JSON.parseObject(string, classOf[ThingListObjectClass]).getThingListObject.getThingObject.get(0).getThingID
    } catch {
      case e: Exception => "null"
    }

    val poScene = try {
      JSON.parseObject(string, classOf[SceneListObjectClass]).getSceneListObject.getSceneObject.get(0).getSceneID
    } catch {
      case e: Exception => "null"
    }

    val poFile = try {
      JSON.parseObject(string, classOf[FileListObjectClass]).getFileListObject.getFile.get(0).getFileInfo.getFileID
    } catch {
      case e: Exception => "null"
    }

    val poVideoSlice = try {
      JSON.parseObject(string, classOf[VideoSliceListObjectClass]).getVideoSliceListObject.getVideoSlice.get(0).getVideoSliceInfo.getVideoID
    } catch {
      case e: Exception => "null"
    }

    val poCase = try {
      JSON.parseObject(string, classOf[CaseListObjectClass]).getCaseListObject.getCase.get(0).getCaseInfo.getCaseID
    } catch {
      case e: Exception => "null"
    }

    //ZA_
    val poFace_ZA = try {
      JSON.parseObject(string, classOf[ZA_FaceCaptureListObjectClass]).getFaceCaptureList.getFaceCaptureObject.get(0).getRLZPXXBZ
    } catch {
      case e: Exception => "null"
    }

    val poMoto_ZA = try {
      JSON.parseObject(string, classOf[ZA_MotorVehicleEventListObiectClass]).getMotorVehicleEventList.getMotorVehicleEventObject.get(0).getJDCGCXXBZ.toString
    } catch {
      case e: Exception => "null"
    }


    if (poFace != "null" && !StringUtils.isEmpty(poFace)) {
      parseJsonFaceListToArrayBuffer(string: String)
    }

    else if (poImage != "null" && !StringUtils.isEmpty(poImage)) {
      parseJsonImageListToArrayBuffer(string: String)
    }

    else if (poPerson != "null" && !StringUtils.isEmpty(poPerson)) {
      parseJsonPersonListToArrayBuffer(string: String)
    }

    else if (poMoto != "null" && !StringUtils.isEmpty(poMoto)) {
      parseJsonMotorVehicleListToArrayBuffer(string: String)
    }

    else if (poNoMoto != "null" && !StringUtils.isEmpty(poNoMoto)) {
      parseJsonNonMotorVehicleListToArrayBuffer(string: String)
    }

    else if (poThing != "null" && !StringUtils.isEmpty(poThing)) {
      parseJsonThingListObjectToArrayBuffer(string: String)
    }

    else if (poScene != "null" && !StringUtils.isEmpty(poScene)) {
      parseJsonSceneListObjectToArrayBuffer(string: String)
    }

    else if (poFile != "null" && !StringUtils.isEmpty(poFile)) {
      parseJsonFileListObjectToArrayBuffer(string: String)
    }

    else if (poVideoSlice != "null" && !StringUtils.isEmpty(poVideoSlice)) {
      parseJsonVideoSliceListObjectToArrayBuffer(string: String)
    }

    else if (poCase != "null" && !StringUtils.isEmpty(poCase)) {
      parseJsonCaseListObjectToArrayBuffer(string: String)
    }

    //ZA
    else if (poFace_ZA != "null" && !StringUtils.isEmpty(poFace_ZA)) {
      parseJsonZA_FaceCaptureListObjectToArrayBuffer(string: String)
    }

    else if (poMoto_ZA != "null" && !StringUtils.isEmpty(poMoto_ZA)) {
      parseJsonZA_MotorVehicleEventListObjectToArrayBuffer(string: String)
    }

    else {
      null
    }
  }


  //todo ===================================================智慧安防 公安部 标准==================================================================================
  //ZA_FaceCaptureListObject
  def parseJsonZA_FaceCaptureListObjectToArrayBuffer(string: String) = {
    val po = JSON.parseObject(string, classOf[ZA_FaceCaptureListObjectClass])
    try {
      ArrayBuffer(
        po.getFaceCaptureList.getFaceCaptureObject.get(0).getRLZPXXBZ + "",
        string + "",
        "ZA_FaceCaptureListdb",
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

        po.getMotorVehicleEventList.getMotorVehicleEventObject.get(0).getJDCGCXXBZ + "",
        string + "",
        "ZA_MotorVehicleEventListdb",
        po.getMotorVehicleEventList.getMotorVehicleEventObject.get(0).getCJSJ + "",
        po.getMotorVehicleEventList.getMotorVehicleEventObject.get(0).getCarWayCode + "",
        po.getMotorVehicleEventList.getMotorVehicleEventObject.get(0).getDevId + "",
        po.getMotorVehicleEventList.getMotorVehicleEventObject.get(0).getCLQJTXBZ + "",
        po.getMotorVehicleEventList.getMotorVehicleEventObject.get(0).getCLXH + "",
        po.getMotorVehicleEventList.getMotorVehicleEventObject.get(0).getJDCCLLXDM + "",
        po.getMotorVehicleEventList.getMotorVehicleEventObject.get(0).getCJSBXXBZ + "",
        po.getMotorVehicleEventList.getMotorVehicleEventObject.get(0).getSFWZDCL_PDBZ + "",
        po.getMotorVehicleEventList.getMotorVehicleEventObject.get(0).getJDCHPZLDM + "",
        po.getMotorVehicleEventList.getMotorVehicleEventObject.get(0).getDevName + "",
        po.getMotorVehicleEventList.getMotorVehicleEventObject.get(0).getIsMotorVehicleReg.toString + "",
        po.getMotorVehicleEventList.getMotorVehicleEventObject.get(0).getGCFX + "",
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


  //todo ===================================================1400 标准==================================================================================
  //CaseListObject
  def parseJsonCaseListObjectToArrayBuffer(string: String) = {
    val po = JSON.parseObject(string, classOf[CaseListObjectClass])
    try {
      ArrayBuffer(

        po.getCaseListObject.getCase.get(0).getCaseInfo.getCaseID + "",
        string + "",
        "CaseListMessagePooldb",
        po.getCaseListObject.getCase.get(0).getCaseInfo.getCaseName + "",
        po.getCaseListObject.getCase.get(0).getCaseInfo.getCaseAbstract + "",
        po.getCaseListObject.getCase.get(0).getCaseInfo.getClueID + "",
        po.getCaseListObject.getCase.get(0).getCaseInfo.getTimeUpLimit + "",
        po.getCaseListObject.getCase.get(0).getCaseInfo.getCreateTime + "",
        po.getCaseListObject.getCase.get(0).getCaseInfo.getPlaceCode + "",
        po.getCaseListObject.getCase.get(0).getCaseInfo.getPlaceFullAddress + "",
        po.getCaseListObject.getCase.get(0).getCaseInfo.getMotorVehicleIDs + "",
        po.getCaseListObject.getCase.get(0).getCaseInfo.getNonMotorVehicleIDs + "",
        po.getCaseListObject.getCase.get(0).getCaseInfo.getPersonIDs + "",
        po.getCaseListObject.getCase.get(0).getCaseInfo.getFaceIDs + "",
        po.getCaseListObject.getCase.get(0).getCaseInfo.getThingIDs + "",
        po.getCaseListObject.getCase.get(0).getCaseInfo.getSceneIDs + "",
        po.getCaseListObject.getCase.get(0).getCaseInfo.getState.toString + "",

        po.getCaseListObject.getCase.get(0).getFileList.getFile.get(0).getFileInfo.getFileID + "",
        po.getCaseListObject.getCase.get(0).getFileList.getFile.get(0).getFileInfo.getInfoKind.toString + "",
        po.getCaseListObject.getCase.get(0).getFileList.getFile.get(0).getFileInfo.getSource + "",
        po.getCaseListObject.getCase.get(0).getFileList.getFile.get(0).getFileInfo.getFileName + "",
        po.getCaseListObject.getCase.get(0).getFileList.getFile.get(0).getFileInfo.getStoragePath + "",
        po.getCaseListObject.getCase.get(0).getFileList.getFile.get(0).getFileInfo.getFileHash + "",
        po.getCaseListObject.getCase.get(0).getFileList.getFile.get(0).getFileInfo.getFileFormat + "",
        po.getCaseListObject.getCase.get(0).getFileList.getFile.get(0).getFileInfo.getTitle + "",
        po.getCaseListObject.getCase.get(0).getFileList.getFile.get(0).getFileInfo.getEntryTime + "",
        po.getCaseListObject.getCase.get(0).getFileList.getFile.get(0).getFileInfo.getFileSize.toString

      )
    } catch {
      case e: Throwable => println(" parse error .. " + e.getMessage)
        null
    }
  }


  //VideoSliceList
  def parseJsonVideoSliceListObjectToArrayBuffer(string: String) = {
    val po = JSON.parseObject(string, classOf[VideoSliceListObjectClass])
    try {
      ArrayBuffer(
        po.getVideoSliceListObject.getVideoSlice.get(0).getVideoSliceInfo.getVideoID + "",
        string + "",
        "VideoSliceListMessagePooldb",
        po.getVideoSliceListObject.getVideoSlice.get(0).getVideoSliceInfo.getInfoKind.toString + "",
        po.getVideoSliceListObject.getVideoSlice.get(0).getVideoSliceInfo.getVideoSource + "",
        po.getVideoSliceListObject.getVideoSlice.get(0).getVideoSliceInfo.getFileHash + "",
        po.getVideoSliceListObject.getVideoSlice.get(0).getVideoSliceInfo.getFileFormat + "",
        po.getVideoSliceListObject.getVideoSlice.get(0).getVideoSliceInfo.getCodedFormat + "",
        po.getVideoSliceListObject.getVideoSlice.get(0).getVideoSliceInfo.getAudioFlag.toString + "",
        po.getVideoSliceListObject.getVideoSlice.get(0).getVideoSliceInfo.getTitle + "",
        po.getVideoSliceListObject.getVideoSlice.get(0).getVideoSliceInfo.getContentDescription + "",
        po.getVideoSliceListObject.getVideoSlice.get(0).getVideoSliceInfo.getShotPlaceCode + "",
        po.getVideoSliceListObject.getVideoSlice.get(0).getVideoSliceInfo.getVideoLen + "",
        po.getVideoSliceListObject.getVideoSlice.get(0).getVideoSliceInfo.getBeginTime + "",
        po.getVideoSliceListObject.getVideoSlice.get(0).getVideoSliceInfo.getEndTime + "",
        po.getVideoSliceListObject.getVideoSlice.get(0).getVideoSliceInfo.getStoragePath + "",
        po.getVideoSliceListObject.getVideoSlice.get(0).getVideoSliceInfo.getThumbnailStoragePath + "",
        po.getVideoSliceListObject.getVideoSlice.get(0).getVideoSliceInfo.getShotPlaceFullAdress + "",
        po.getVideoSliceListObject.getVideoSlice.get(0).getVideoSliceInfo.getShotPlaceLongitude.toString + "",
        po.getVideoSliceListObject.getVideoSlice.get(0).getVideoSliceInfo.getShotPlaceLatitude.toString + "",
        po.getVideoSliceListObject.getVideoSlice.get(0).getVideoSliceInfo.getEntryClerkOrg + "",
        po.getVideoSliceListObject.getVideoSlice.get(0).getVideoSliceInfo.getEntryTime + "",
        po.getVideoSliceListObject.getVideoSlice.get(0).getVideoSliceInfo.getFileSize.toString

      )
    } catch {
      case e: Throwable => println(" parse error .. " + e.getMessage)
        null
    }
  }

  //FileListObject
  def parseJsonFileListObjectToArrayBuffer(string: String) = {
    val po = JSON.parseObject(string, classOf[FileListObjectClass])
    try {
      ArrayBuffer(

        po.getFileListObject.getFile.get(0).getFileInfo.getFileID + "",
        string + "",
        "FileListMessagePooldb",
        po.getFileListObject.getFile.get(0).getFileInfo.getInfoKind.toString + "",
        po.getFileListObject.getFile.get(0).getFileInfo.getSource + "",
        po.getFileListObject.getFile.get(0).getFileInfo.getFileName + "",
        po.getFileListObject.getFile.get(0).getFileInfo.getStoragePath + "",
        po.getFileListObject.getFile.get(0).getFileInfo.getFileHash + "",
        po.getFileListObject.getFile.get(0).getFileInfo.getFileFormat + "",
        po.getFileListObject.getFile.get(0).getFileInfo.getTitle + "",
        po.getFileListObject.getFile.get(0).getFileInfo.getEntryTime + "",
        po.getFileListObject.getFile.get(0).getFileInfo.getFileSize.toString + ""

      )
    } catch {
      case e: Throwable => println(" parse error .. " + e.getMessage)
        null
    }
  }

  //SceneListObject
  def parseJsonSceneListObjectToArrayBuffer(string: String) = {
    val po = JSON.parseObject(string, classOf[SceneListObjectClass])
    try {
      ArrayBuffer(
        po.getSceneListObject.getSceneObject.get(0).getSceneID + "",
        string + "",
        "SceneListMessagePooldb",
        po.getSceneListObject.getSceneObject.get(0).getInfoKind.toString + "",
        po.getSceneListObject.getSceneObject.get(0).getSourceID + "",
        po.getSceneListObject.getSceneObject.get(0).getDeviceID + "",
        po.getSceneListObject.getSceneObject.get(0).getBeginTime + "",
        po.getSceneListObject.getSceneObject.get(0).getPlaceType + "",
        po.getSceneListObject.getSceneObject.get(0).getWeatherType + "",
        po.getSceneListObject.getSceneObject.get(0).getSceneDescribe + "",
        po.getSceneListObject.getSceneObject.get(0).getSceneType + "",
        po.getSceneListObject.getSceneObject.get(0).getRoadAlignmentType + "",
        po.getSceneListObject.getSceneObject.get(0).getRoadTerrainType.toString + "",
        po.getSceneListObject.getSceneObject.get(0).getRoadSurfaceType + "",
        po.getSceneListObject.getSceneObject.get(0).getRoadCoditionType + "",
        po.getSceneListObject.getSceneObject.get(0).getRoadJunctionSectionType + "",
        po.getSceneListObject.getSceneObject.get(0).getRoadLightingType + "",
        po.getSceneListObject.getSceneObject.get(0).getIllustration + "",
        po.getSceneListObject.getSceneObject.get(0).getWindDirection + "",
        po.getSceneListObject.getSceneObject.get(0).getIllumination + "",
        po.getSceneListObject.getSceneObject.get(0).getFieldCondition + "",
        po.getSceneListObject.getSceneObject.get(0).getTemperature.toString + "",
        po.getSceneListObject.getSceneObject.get(0).getHumidity + "",
        po.getSceneListObject.getSceneObject.get(0).getPopulationDensity + "",
        po.getSceneListObject.getSceneObject.get(0).getDenseDegree + "",
        po.getSceneListObject.getSceneObject.get(0).getImportance.toString + "",

        po.getSceneListObject.getSceneObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getImageID + "",
        po.getSceneListObject.getSceneObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getEventSort.toString + "",
        po.getSceneListObject.getSceneObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getDeviceID + "",
        po.getSceneListObject.getSceneObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getStoragePath + "",
        po.getSceneListObject.getSceneObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getType + "",
        po.getSceneListObject.getSceneObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getFileFormat + "",
        po.getSceneListObject.getSceneObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getShotTime + "",
        po.getSceneListObject.getSceneObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getWidth.toString + "",
        po.getSceneListObject.getSceneObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getHeight.toString
      )
    } catch {
      case e: Throwable => println(" parse error .. " + e.getMessage)
        null
    }
  }

  //ThingListObject
  def parseJsonThingListObjectToArrayBuffer(string: String) = {
    val po = JSON.parseObject(string, classOf[ThingListObjectClass])
    try {
      ArrayBuffer(
        po.getThingListObject.getThingObject.get(0).getThingID + "",
        string + "",
        "ThingListMessagePooldb",
        po.getThingListObject.getThingObject.get(0).getInfoKind.toString + "",
        po.getThingListObject.getThingObject.get(0).getSourceID + "",
        po.getThingListObject.getThingObject.get(0).getDeviceID + "",
        po.getThingListObject.getThingObject.get(0).getLeftTopX.toString + "",
        po.getThingListObject.getThingObject.get(0).getLeftTopY.toString + "",
        po.getThingListObject.getThingObject.get(0).getRightBtmX.toString + "",
        po.getThingListObject.getThingObject.get(0).getRightBtmY.toString + "",
        po.getThingListObject.getThingObject.get(0).getLocationMarkTime + "",
        po.getThingListObject.getThingObject.get(0).getAppearTime + "",
        po.getThingListObject.getThingObject.get(0).getDisappearTime + "",
        po.getThingListObject.getThingObject.get(0).getName + "",
        po.getThingListObject.getThingObject.get(0).getShape + "",
        po.getThingListObject.getThingObject.get(0).getColor + "",
        po.getThingListObject.getThingObject.get(0).getSize + "",
        po.getThingListObject.getThingObject.get(0).getMaterial + "",
        po.getThingListObject.getThingObject.get(0).getCharacteristic + "",
        po.getThingListObject.getThingObject.get(0).getPropertiy + "",
        po.getThingListObject.getThingObject.get(0).getInvolvedObjType + "",
        po.getThingListObject.getThingObject.get(0).getFirearmsAmmunitionType + "",
        po.getThingListObject.getThingObject.get(0).getToolTraceType + "",
        po.getThingListObject.getThingObject.get(0).getEvidenceType + "",
        po.getThingListObject.getThingObject.get(0).getCaseEvidenceType + "",
        po.getThingListObject.getThingObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getImageID + "",
        po.getThingListObject.getThingObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getEventSort.toString + "",
        po.getThingListObject.getThingObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getDeviceID + "",
        po.getThingListObject.getThingObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getStoragePath + "",
        po.getThingListObject.getThingObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getType + "",
        po.getThingListObject.getThingObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getFileFormat + "",
        po.getThingListObject.getThingObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getShotTime + "",
        po.getThingListObject.getThingObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getWidth.toString + "",
        po.getThingListObject.getThingObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getHeight.toString
      )
    } catch {
      case e: Throwable => println(" parse error .. " + e.getMessage)
        null
    }
  }


  //NonMotorVehicleListObject
  def parseJsonNonMotorVehicleListToArrayBuffer(string: String) = {
    val po = JSON.parseObject(string, classOf[NonMotorVehicleListObjectClass])
    try {
      ArrayBuffer(
        po.getNonMotorVehicleListObject.getNonMotorVehicleObject.get(0).getNonMotorVehicleID + "",
        string + "",
        "NonMotorVehicleListMessagePooldb",
        po.getNonMotorVehicleListObject.getNonMotorVehicleObject.get(0).getInfoKind.toString + "",
        po.getNonMotorVehicleListObject.getNonMotorVehicleObject.get(0).getSourceID + "",
        po.getNonMotorVehicleListObject.getNonMotorVehicleObject.get(0).getDeviceID + "",
        po.getNonMotorVehicleListObject.getNonMotorVehicleObject.get(0).getLeftTopX.toString + "",
        po.getNonMotorVehicleListObject.getNonMotorVehicleObject.get(0).getLeftTopY.toString + "",
        po.getNonMotorVehicleListObject.getNonMotorVehicleObject.get(0).getRightBtmX.toString + "",
        po.getNonMotorVehicleListObject.getNonMotorVehicleObject.get(0).getRightBtmY.toString + "",
        po.getNonMotorVehicleListObject.getNonMotorVehicleObject.get(0).getHasPlate + "",
        po.getNonMotorVehicleListObject.getNonMotorVehicleObject.get(0).getPlateClass + "",
        po.getNonMotorVehicleListObject.getNonMotorVehicleObject.get(0).getPlateColor + "",
        po.getNonMotorVehicleListObject.getNonMotorVehicleObject.get(0).getPlateNo + "",
        po.getNonMotorVehicleListObject.getNonMotorVehicleObject.get(0).getPlateNoAttach + "",
        po.getNonMotorVehicleListObject.getNonMotorVehicleObject.get(0).getPlateDescribe + "",
        po.getNonMotorVehicleListObject.getNonMotorVehicleObject.get(0).getIsDecked + "",
        po.getNonMotorVehicleListObject.getNonMotorVehicleObject.get(0).getIsAltered + "",
        po.getNonMotorVehicleListObject.getNonMotorVehicleObject.get(0).getIsCovered + "",
        po.getNonMotorVehicleListObject.getNonMotorVehicleObject.get(0).getDrivingStatusCode + "",
        po.getNonMotorVehicleListObject.getNonMotorVehicleObject.get(0).getUsingPropertiesCode + "",
        po.getNonMotorVehicleListObject.getNonMotorVehicleObject.get(0).getVehicleBrand + "",
        po.getNonMotorVehicleListObject.getNonMotorVehicleObject.get(0).getVehicleType + "",
        po.getNonMotorVehicleListObject.getNonMotorVehicleObject.get(0).getVehicleLength.toString + "",
        po.getNonMotorVehicleListObject.getNonMotorVehicleObject.get(0).getVehicleWidth.toString + "",
        po.getNonMotorVehicleListObject.getNonMotorVehicleObject.get(0).getVehicleHeight.toString + "",
        po.getNonMotorVehicleListObject.getNonMotorVehicleObject.get(0).getVehicleColor + "",
        po.getNonMotorVehicleListObject.getNonMotorVehicleObject.get(0).getVehicleHood + "",
        po.getNonMotorVehicleListObject.getNonMotorVehicleObject.get(0).getVehicleTrunk + "",
        po.getNonMotorVehicleListObject.getNonMotorVehicleObject.get(0).getVehicleWheel + "",
        po.getNonMotorVehicleListObject.getNonMotorVehicleObject.get(0).getWheelPrintedPattern + "",
        po.getNonMotorVehicleListObject.getNonMotorVehicleObject.get(0).getVehicleWindow + "",
        po.getNonMotorVehicleListObject.getNonMotorVehicleObject.get(0).getVehicleRoof + "",
        po.getNonMotorVehicleListObject.getNonMotorVehicleObject.get(0).getVehicleDoor + "",
        po.getNonMotorVehicleListObject.getNonMotorVehicleObject.get(0).getSideOfVehicle + "",
        po.getNonMotorVehicleListObject.getNonMotorVehicleObject.get(0).getCarOfVehicle + "",
        po.getNonMotorVehicleListObject.getNonMotorVehicleObject.get(0).getRearviewMirror + "",
        po.getNonMotorVehicleListObject.getNonMotorVehicleObject.get(0).getVehicleChassis + "",
        po.getNonMotorVehicleListObject.getNonMotorVehicleObject.get(0).getVehicleShielding + "",
        po.getNonMotorVehicleListObject.getNonMotorVehicleObject.get(0).getFilmColor + "",

        po.getNonMotorVehicleListObject.getNonMotorVehicleObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getImageID + "",
        po.getNonMotorVehicleListObject.getNonMotorVehicleObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getEventSort.toString + "",
        po.getNonMotorVehicleListObject.getNonMotorVehicleObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getDeviceID + "",
        po.getNonMotorVehicleListObject.getNonMotorVehicleObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getStoragePath + "",
        po.getNonMotorVehicleListObject.getNonMotorVehicleObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getType + "",
        po.getNonMotorVehicleListObject.getNonMotorVehicleObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getFileFormat + "",
        po.getNonMotorVehicleListObject.getNonMotorVehicleObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getShotTime + "",
        po.getNonMotorVehicleListObject.getNonMotorVehicleObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getWidth.toString + "",
        po.getNonMotorVehicleListObject.getNonMotorVehicleObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getHeight.toString + ""
      )
    } catch {
      case e: Throwable => println(" parse error .. " + e.getMessage)
        null
    }
  }

  //  MotorVehicleListObject
  def parseJsonMotorVehicleListToArrayBuffer(string: String) = {
    val po = JSON.parseObject(string, classOf[MotorVehicleListObjectClass])
    try {
      ArrayBuffer(
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getMotorVehicleID + "",
        string + "",
        "MotorVehicleListMessagePooldb",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getInfoKind.toString + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getSourceID + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getTollgateID + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getDeviceID + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getStorageUrl1 + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getStorageUrl3 + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getStorageUrl5 + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getLeftTopX.toString + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getLeftTopY.toString + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getRightBtmX.toString + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getRightBtmY.toString + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getLaneNo.toString + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getHasPlate + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getPlateClass + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getPlateColor + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getPlateNo + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getPlateNoAttach + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getPlateDescribe + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getIsDecked + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getIsAltered + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getIsCovered + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getSpeed + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getDirection + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getDrivingStatusCode + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getUsingPropertiesCode + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getVehicleClass + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getVehicleBrand + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getVehicleModel + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getVehicleStyles + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getVehicleLength.toString + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getVehicleWidth.toString + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getVehicleHeight.toString + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getVehicleColor + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getVehicleColorDepth + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getVehicleHood + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getVehicleTrunk + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getVehicleWheel + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getWheelPrintedPattern + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getVehicleWindow + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getVehicleRoof + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getVehicleDoor + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getSideOfVehicle + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getCarOfVehicle + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getRearviewMirror + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getVehicleChassis + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getVehicleShielding + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getFilmColor + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getIsModified + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getHitMarkInfo + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getVehicleBodyDesc + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getVehicleFrontItem + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getDescOfFrontItem + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getVehicleRearItem + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getDescOfRearItem + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getNumOfPassenger.toString + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getPassTime + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getNameOfPassedRoad + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getIsSuspicious + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getPlateReliability + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getPlateCharReliability + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getBrandReliability + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getImageID + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getEventSort.toString + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getDeviceID + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getStoragePath + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getType + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getFileFormat + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getShotTime + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getWidth.toString + "",
        po.getMotorVehicleListObject.getMotorVehicleObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getHeight.toString + ""
      )
    } catch {
      case e: Throwable => println(" parse error .. " + e.getMessage)
        null
    }
  }

  //  faceListMessagePooldb
  def parseJsonFaceListToArrayBuffer(string: String) = {
    val po = JSON.parseObject(string, classOf[FaceListObjectClass])

    try {
      ArrayBuffer(

        po.getFaceListObject.getFaceObject.get(0).getFaceID + "",
        string + "",
        "faceListMessagePooldb",
        po.getFaceListObject.getFaceObject.get(0).getInfoKind.toString + "",
        po.getFaceListObject.getFaceObject.get(0).getSourceID + "",
        po.getFaceListObject.getFaceObject.get(0).getDeviceID + "",
        po.getFaceListObject.getFaceObject.get(0).getLeftTopX.toString + "",
        po.getFaceListObject.getFaceObject.get(0).getLeftTopY.toString + "",
        po.getFaceListObject.getFaceObject.get(0).getRightBtmX.toString + "",
        po.getFaceListObject.getFaceObject.get(0).getRightBtmY.toString + "",
        po.getFaceListObject.getFaceObject.get(0).getLocationMarkTime + "",
        po.getFaceListObject.getFaceObject.get(0).getFaceAppearTime + "",
        po.getFaceListObject.getFaceObject.get(0).getFaceDisAppearTime + "",
        po.getFaceListObject.getFaceObject.get(0).getIDType + "",
        po.getFaceListObject.getFaceObject.get(0).getIDNumber + "",
        po.getFaceListObject.getFaceObject.get(0).getName + "",
        po.getFaceListObject.getFaceObject.get(0).getUsedName + "",
        po.getFaceListObject.getFaceObject.get(0).getAlias + "",
        po.getFaceListObject.getFaceObject.get(0).getGenderCode + "",
        po.getFaceListObject.getFaceObject.get(0).getAgeUpLimit.toString + "",
        po.getFaceListObject.getFaceObject.get(0).getAgeLowerLimit.toString + "",
        po.getFaceListObject.getFaceObject.get(0).getEthicCode + "",
        po.getFaceListObject.getFaceObject.get(0).getNationalityCode + "",
        po.getFaceListObject.getFaceObject.get(0).getNativeCityCode + "",
        po.getFaceListObject.getFaceObject.get(0).getResidenceAdminDivision + "",
        po.getFaceListObject.getFaceObject.get(0).getChineseAccentCode + "",
        po.getFaceListObject.getFaceObject.get(0).getJobCategory + "",
        po.getFaceListObject.getFaceObject.get(0).getAccompanyNumber.toString + "",
        po.getFaceListObject.getFaceObject.get(0).getSkinColor + "",
        po.getFaceListObject.getFaceObject.get(0).getHairStyle + "",
        po.getFaceListObject.getFaceObject.get(0).getHairColor + "",
        po.getFaceListObject.getFaceObject.get(0).getFaceStyle + "",
        po.getFaceListObject.getFaceObject.get(0).getFacialFeature + "",
        po.getFaceListObject.getFaceObject.get(0).getPhysicalFeature + "",
        po.getFaceListObject.getFaceObject.get(0).getRespiratorColor + "",
        po.getFaceListObject.getFaceObject.get(0).getCapStyle + "",
        po.getFaceListObject.getFaceObject.get(0).getCapColor + "",
        po.getFaceListObject.getFaceObject.get(0).getGlassStyle + "",
        po.getFaceListObject.getFaceObject.get(0).getGlassColor + "",
        po.getFaceListObject.getFaceObject.get(0).getIsDriver.toString + "",
        po.getFaceListObject.getFaceObject.get(0).getIsForeigner.toString + "",
        po.getFaceListObject.getFaceObject.get(0).getPassportType + "",
        po.getFaceListObject.getFaceObject.get(0).getImmigrantTypeCode + "",
        po.getFaceListObject.getFaceObject.get(0).getIsSuspectedTerrorist.toString + "",
        po.getFaceListObject.getFaceObject.get(0).getSuspectedTerroristNumber + "",
        po.getFaceListObject.getFaceObject.get(0).getIsCriminalInvolved.toString + "",
        po.getFaceListObject.getFaceObject.get(0).getCriminalInvolvedSpecilisationCode + "",
        po.getFaceListObject.getFaceObject.get(0).getBodySpeciallMark + "",
        po.getFaceListObject.getFaceObject.get(0).getCrimeMethod + "",
        po.getFaceListObject.getFaceObject.get(0).getCrimeCharacterCode + "",
        po.getFaceListObject.getFaceObject.get(0).getEscapedCriminalNumber + "",
        po.getFaceListObject.getFaceObject.get(0).getIsDetainees.toString + "",
        po.getFaceListObject.getFaceObject.get(0).getDetentionHouseCode + "",
        po.getFaceListObject.getFaceObject.get(0).getDetaineesIdentity + "",
        po.getFaceListObject.getFaceObject.get(0).getDetaineesSpecialIdentity + "",
        po.getFaceListObject.getFaceObject.get(0).getMemberTypeCode + "",
        po.getFaceListObject.getFaceObject.get(0).getIsVictim.toString + "",
        po.getFaceListObject.getFaceObject.get(0).getVictimType + "",
        po.getFaceListObject.getFaceObject.get(0).getInjuredDegree + "",
        po.getFaceListObject.getFaceObject.get(0).getCorpseConditionCode + "",
        po.getFaceListObject.getFaceObject.get(0).getIsSuspiciousPerson.toString + "",
        po.getFaceListObject.getFaceObject.get(0).getAttitude.toString + "",
        po.getFaceListObject.getFaceObject.get(0).getSimilaritydegree.toString + "",
        po.getFaceListObject.getFaceObject.get(0).getEyebrowStyle + "",
        po.getFaceListObject.getFaceObject.get(0).getNoseStyle + "",
        po.getFaceListObject.getFaceObject.get(0).getMustacheStyle + "",
        po.getFaceListObject.getFaceObject.get(0).getLipStyle + "",
        po.getFaceListObject.getFaceObject.get(0).getWrinklePouch + "",
        po.getFaceListObject.getFaceObject.get(0).getAcneStain + "",
        po.getFaceListObject.getFaceObject.get(0).getFreckleBirthmark + "",
        po.getFaceListObject.getFaceObject.get(0).getScarDimple + "",
        po.getFaceListObject.getFaceObject.get(0).getOtherFeature + "",
        po.getFaceListObject.getFaceObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getImageID + "",
        po.getFaceListObject.getFaceObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getEventSort.toString + "",
        po.getFaceListObject.getFaceObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getDeviceID + "",
        po.getFaceListObject.getFaceObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getStoragePath + "",
        po.getFaceListObject.getFaceObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getType + "",
        po.getFaceListObject.getFaceObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getFileFormat + "",
        po.getFaceListObject.getFaceObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getShotTime + "",
        po.getFaceListObject.getFaceObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getWidth.toString + "",
        po.getFaceListObject.getFaceObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getHeight.toString + ""
      )
    } catch {
      case e: Throwable => println(" parse error .. " + e.getMessage)
        null
    }
  }

  //  imageListMessagePooldb
  def parseJsonImageListToArrayBuffer(string: String) = {
    val po = JSON.parseObject(string, classOf[ImageListObjectClass])

    try {
      ArrayBuffer(

        po.getImageListObject.getImage.get(0).getImageInfo.getImageID + "",
        string + "",
        "imageListMessagePooldb",
        po.getImageListObject.getImage.get(0).getImageInfo.getInfoKind.toString + "",
        po.getImageListObject.getImage.get(0).getImageInfo.getImageSource + "",
        po.getImageListObject.getImage.get(0).getImageInfo.getEventSort.toString + "",
        po.getImageListObject.getImage.get(0).getImageInfo.getStoragePath + "",
        po.getImageListObject.getImage.get(0).getImageInfo.getShotTime + "",
        po.getImageListObject.getImage.get(0).getImageInfo.getShotPlaceFullAdress + "",
        po.getImageListObject.getImage.get(0).getImageInfo.getShotPlaceLongitude.toString + "",
        po.getImageListObject.getImage.get(0).getImageInfo.getShotPlaceLatitude.toString + "",
        po.getImageListObject.getImage.get(0).getImageInfo.getEntryClerkOrg + "",
        po.getImageListObject.getImage.get(0).getImageInfo.getEntryTime + "",
        po.getImageListObject.getImage.get(0).getImageInfo.getFileHash + "",
        po.getImageListObject.getImage.get(0).getImageInfo.getFileFormat + "",
        po.getImageListObject.getImage.get(0).getImageInfo.getTitle + "",
        po.getImageListObject.getImage.get(0).getImageInfo.getContentDescription + "",
        po.getImageListObject.getImage.get(0).getImageInfo.getWidth.toString + "",
        po.getImageListObject.getImage.get(0).getImageInfo.getHeight.toString + "",
        po.getImageListObject.getImage.get(0).getImageInfo.getSecurityLevel.toString + "",
        po.getImageListObject.getImage.get(0).getImageInfo.getFileSize.toString + ""

      )
    } catch {
      case e: Throwable => println(" parse error .. " + e.getMessage)
        null
    }
  }

  //  personListMessagePooldb
  def parseJsonPersonListToArrayBuffer(string: String) = {
    val po = JSON.parseObject(string, classOf[PersonListObjectClass])

    try {
      ArrayBuffer(

        po.getPersonListObject.getPersonObject.get(0).getPersonID + "",
        string + "",
        "personListMessagePooldb",
        po.getPersonListObject.getPersonObject.get(0).getInfoKind.toString + "",
        po.getPersonListObject.getPersonObject.get(0).getSourceID + "",
        po.getPersonListObject.getPersonObject.get(0).getDeviceID + "",
        po.getPersonListObject.getPersonObject.get(0).getLeftTopX.toString + "",
        po.getPersonListObject.getPersonObject.get(0).getLeftTopY.toString + "",
        po.getPersonListObject.getPersonObject.get(0).getRightBtmX.toString + "",
        po.getPersonListObject.getPersonObject.get(0).getRightBtmY.toString + "",
        po.getPersonListObject.getPersonObject.get(0).getLocationMarkTime + "",
        po.getPersonListObject.getPersonObject.get(0).getPersonAppearTime + "",
        po.getPersonListObject.getPersonObject.get(0).getPersonDisAppearTime + "",
        po.getPersonListObject.getPersonObject.get(0).getIDType + "",
        po.getPersonListObject.getPersonObject.get(0).getIDNumber + "",
        po.getPersonListObject.getPersonObject.get(0).getName + "",
        po.getPersonListObject.getPersonObject.get(0).getUsedName + "",
        po.getPersonListObject.getPersonObject.get(0).getAlias + "",
        po.getPersonListObject.getPersonObject.get(0).getGenderCode + "",
        po.getPersonListObject.getPersonObject.get(0).getAgeUpLimit.toString + "",
        po.getPersonListObject.getPersonObject.get(0).getAgeLowerLimit.toString + "",
        po.getPersonListObject.getPersonObject.get(0).getEthicCode + "",
        po.getPersonListObject.getPersonObject.get(0).getNationalityCode + "",
        po.getPersonListObject.getPersonObject.get(0).getNativeCityCode + "",
        po.getPersonListObject.getPersonObject.get(0).getResidenceAdminDivision + "",
        po.getPersonListObject.getPersonObject.get(0).getChineseAccentCode + "",
        po.getPersonListObject.getPersonObject.get(0).getPersonOrg + "",
        po.getPersonListObject.getPersonObject.get(0).getJobCategory + "",
        po.getPersonListObject.getPersonObject.get(0).getAccompanyNumber.toString + "",
        po.getPersonListObject.getPersonObject.get(0).getHeightUpLimit.toString + "",
        po.getPersonListObject.getPersonObject.get(0).getHeightLowerLimit.toString + "",
        po.getPersonListObject.getPersonObject.get(0).getBodyType + "",
        po.getPersonListObject.getPersonObject.get(0).getSkinColor + "",
        po.getPersonListObject.getPersonObject.get(0).getHairStyle + "",
        po.getPersonListObject.getPersonObject.get(0).getHairColor + "",
        po.getPersonListObject.getPersonObject.get(0).getGesture + "",
        po.getPersonListObject.getPersonObject.get(0).getStatus + "",
        po.getPersonListObject.getPersonObject.get(0).getFaceStyle + "",
        po.getPersonListObject.getPersonObject.get(0).getFacialFeature + "",
        po.getPersonListObject.getPersonObject.get(0).getPhysicalFeature + "",
        po.getPersonListObject.getPersonObject.get(0).getBodyFeature + "",
        po.getPersonListObject.getPersonObject.get(0).getHabitualMovement + "",
        po.getPersonListObject.getPersonObject.get(0).getBehavior + "",
        po.getPersonListObject.getPersonObject.get(0).getBehaviorDescription + "",
        po.getPersonListObject.getPersonObject.get(0).getAppendant + "",
        po.getPersonListObject.getPersonObject.get(0).getAppendantDescription + "",
        po.getPersonListObject.getPersonObject.get(0).getUmbrellaColor + "",
        po.getPersonListObject.getPersonObject.get(0).getRespiratorColor + "",
        po.getPersonListObject.getPersonObject.get(0).getCapStyle + "",
        po.getPersonListObject.getPersonObject.get(0).getCapColor + "",
        po.getPersonListObject.getPersonObject.get(0).getGlassStyle + "",
        po.getPersonListObject.getPersonObject.get(0).getGlassColor + "",
        po.getPersonListObject.getPersonObject.get(0).getScarfColor + "",
        po.getPersonListObject.getPersonObject.get(0).getBagStyle + "",
        po.getPersonListObject.getPersonObject.get(0).getBagColor + "",
        po.getPersonListObject.getPersonObject.get(0).getCoatStyle + "",
        po.getPersonListObject.getPersonObject.get(0).getCoatLength + "",
        po.getPersonListObject.getPersonObject.get(0).getCoatColor + "",
        po.getPersonListObject.getPersonObject.get(0).getTrousersStyle + "",
        po.getPersonListObject.getPersonObject.get(0).getTrousersColor + "",
        po.getPersonListObject.getPersonObject.get(0).getTrousersLen + "",
        po.getPersonListObject.getPersonObject.get(0).getShoesStyle + "",
        po.getPersonListObject.getPersonObject.get(0).getShoesColor + "",
        po.getPersonListObject.getPersonObject.get(0).getIsDriver.toString + "",
        po.getPersonListObject.getPersonObject.get(0).getIsForeigner.toString + "",
        po.getPersonListObject.getPersonObject.get(0).getPassportType + "",
        po.getPersonListObject.getPersonObject.get(0).getImmigrantTypeCode + "",
        po.getPersonListObject.getPersonObject.get(0).getIsSuspectedTerrorist.toString + "",
        po.getPersonListObject.getPersonObject.get(0).getSuspectedTerroristNumber + "",
        po.getPersonListObject.getPersonObject.get(0).getIsCriminalInvolved.toString + "",
        po.getPersonListObject.getPersonObject.get(0).getCriminalInvolvedSpecilisationCode + "",
        po.getPersonListObject.getPersonObject.get(0).getBodySpeciallMark + "",
        po.getPersonListObject.getPersonObject.get(0).getCrimeMethod + "",
        po.getPersonListObject.getPersonObject.get(0).getCrimeCharacterCode + "",
        po.getPersonListObject.getPersonObject.get(0).getEscapedCriminalNumber + "",
        po.getPersonListObject.getPersonObject.get(0).getIsDetainees.toString + "",
        po.getPersonListObject.getPersonObject.get(0).getDetentionHouseCode + "",
        po.getPersonListObject.getPersonObject.get(0).getDetaineesIdentity + "",
        po.getPersonListObject.getPersonObject.get(0).getDetaineesSpecialIdentity + "",
        po.getPersonListObject.getPersonObject.get(0).getMemberTypeCode + "",
        po.getPersonListObject.getPersonObject.get(0).getIsVictim.toString + "",
        po.getPersonListObject.getPersonObject.get(0).getVictimType + "",
        po.getPersonListObject.getPersonObject.get(0).getInjuredDegree + "",
        po.getPersonListObject.getPersonObject.get(0).getCorpseConditionCode + "",
        po.getPersonListObject.getPersonObject.get(0).getIsSuspiciousPerson.toString + "",
        po.getPersonListObject.getPersonObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getImageID + "",
        po.getPersonListObject.getPersonObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getEventSort.toString + "",
        po.getPersonListObject.getPersonObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getDeviceID + "",
        po.getPersonListObject.getPersonObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getStoragePath + "",
        po.getPersonListObject.getPersonObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getType + "",
        po.getPersonListObject.getPersonObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getFileFormat + "",
        po.getPersonListObject.getPersonObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getShotTime + "",
        po.getPersonListObject.getPersonObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getWidth.toString + "",
        po.getPersonListObject.getPersonObject.get(0).getSubImageList.getSubImageInfoObject.get(0).getHeight.toString + ""

      )
    } catch {
      case e: Throwable => println(" parse error .. " + e.getMessage)
        null
    }
  }


  def main(args: Array[String]): Unit = {

    //    println(DateTime.now().toDateStr.replace("-",""))


  }


}


