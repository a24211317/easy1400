<template>
  <div class="app-container">
    <div>
      <el-row :gutter="0">
        <el-form
          ref="elForm"
          :model="formData"
          :rules="rules"
          size="medium"
          label-width="85px"
        >
          <el-col :span="4"> </el-col>
          <el-col :span="4">
            <el-form-item label="设备ID" prop="ApeID">
              <el-input
                v-model="formData.ApeID"
                clearable
                :style="{ width: '90%' }"
              >
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="4">
            <el-form-item label="设备名称" prop="Name">
              <el-input
                v-model="formData.Name"
                clearable
                :style="{ width: '90%' }"
              >
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="1">
            <el-form-item label-width="1px">
              <el-button
                type="primary"
                icon="el-icon-search"
                size="medium"
                @click="submitForm"
              >
                查询
              </el-button>
            </el-form-item>
          </el-col>
        </el-form>
      </el-row>
    </div>
    <div></div>
    <div>
      <el-table :data="apesDataList" style="width: 100%">
        <el-table-column prop="ApeID" label="设备ID"> </el-table-column>
        <el-table-column prop="Name" label="名称"> </el-table-column>
        <el-table-column prop="Model" label="型号"> </el-table-column>
        <el-table-column prop="IPAddr" label="IP地址"> </el-table-column>
        <el-table-column prop="IPV6Addr" label="IPv6地址"> </el-table-column>
        <el-table-column prop="Port" label="端口号"> </el-table-column>
        <el-table-column prop="Longitude" label="经度"> </el-table-column>
        <el-table-column prop="Latitude" label="纬度"> </el-table-column>
        <el-table-column prop="PlaceCode" label="行政区划代码"> </el-table-column>
        <el-table-column prop="Place" label="位置名"> </el-table-column>
        <el-table-column prop="OrgCode" label="管辖单位代码"> </el-table-column>
        <el-table-column prop="CapDirection" label="车辆抓拍方向"> </el-table-column>
        <el-table-column prop="MonitorDirection" label="监视方向"> </el-table-column>
        <el-table-column prop="MonitorAreaDesc" label="监视区域说明"> </el-table-column>
        <el-table-column prop="IsOnline" label="是否在线"> </el-table-column>
        <el-table-column prop="OwnerApsID" label="所属采集系统"> </el-table-column>
        <el-table-column prop="UserId" label="用户帐号"> </el-table-column>
        <el-table-column prop="Password" label="口令"> </el-table-column>
      </el-table>
    </div>
    <div class="block">
      <el-pagination
        align="center"
        @current-change="handleCurrentChange"
        layout="prev, pager, next"
        :total="dataTotal"
        :page-size="8"
      >
      </el-pagination>
    </div>
  </div>
</template>

<script>
import { getApesPage } from "@/api/viid/data/apesData";
import { getToken } from "@/utils/auth";

export default {
  name: "apesData",
  data() {
    return {
      apesDataList: [],
      formData: {
        page: 1,
        rows: 8,
        ApeID: "",
        Name: ""
      },
      dataTotal: 1
    };
  },
  computed: {},
  watch: {},
  created() {
    //查询车辆数据
    this.getApesPage();
  },
  mounted() {},
  methods: {
    getApesPage() {
      var _this = this;
      getApesPage(this.formData).then((response) => {
        console.log(response.data);
        var data = response;
        _this.dataTotal = data.total;
        console.log(data.records);
        _this.apesDataList = data.records;
      });
    },
    submitForm() {
      var _this = this;
      this.$refs["elForm"].validate((valid) => {
        if (!valid) return;
        //  提交表单
        _this.getApesPage();
      });
    },
    //当前页改变时触发 跳转其他页
    handleCurrentChange(val) {
      this.formData.page = val;
      this.getFacePage();
    },
  },
};
</script>
<style>
.face-data-col-text {
  white-space: nowrap;
  text-overflow: ellipsis;
  overflow: hidden;
  width: 100%;
  display: block;
}
.face_img {
  margin: 1%;
  width: 98%;
  height: 18rem;
}
.face-data-col {
  margin-bottom: 20px;
  border-radius: 4px;
}
.bg-purple-dark {
  background: #99a9bf;
}
.bg-purple {
  width: 100%;
  height: 100%;
  background: #d3dce6;
}
.bg-purple-light {
  background: #e5e9f2;
}
.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
.row-bg {
  padding: 10px 0;
  background-color: #f9fafc;
}
.el-image__error {
}
</style>