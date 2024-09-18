<template>
  <div class="app-container">
    <div>
      <el-row :gutter="0">
        <el-form ref="elForm" :model="formData" :rules="rules" size="medium" label-width="85px">
          <el-col :span="4"> </el-col>
          <el-col :span="4">
            <el-form-item label="设备ID" prop="ApeID">
              <el-input v-model="formData.ApeID" clearable :style="{ width: '90%' }">
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="4">
            <el-form-item label="设备名称" prop="Name">
              <el-input v-model="formData.Name" clearable :style="{ width: '90%' }">
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="1">
            <el-form-item label-width="1px">
              <el-button type="primary" icon="el-icon-search" size="medium" @click="submitForm">
                查询
              </el-button>
            </el-form-item>
          </el-col>
        </el-form>
        <div style="float: right">
          <el-col :span="1.5">
            <el-button type="primary" plain icon="el-icon-plus" size="medium" @click="
              addFormOpen = true;
            addFormTitle = `新增采集设备`;
            addFormID = 0;
            addForm = {};
            ">新增
            </el-button>
          </el-col>
        </div>
      </el-row>
    </div>
    <div></div>
    <div style="width: 99%;overflow-x: auto;">
      <el-table :data="apesDataList" style="width: 100%">
        <el-table-column width="200" prop="ApeID" label="设备ID"> </el-table-column>
        <el-table-column prop="Name" label="名称"> </el-table-column>
        <el-table-column prop="Model" label="型号"> </el-table-column>
        <el-table-column width="200" prop="IPAddr" label="IP地址"> </el-table-column>
        <el-table-column width="200" prop="IPV6Addr" label="IPv6地址"> </el-table-column>
        <el-table-column prop="Port" label="端口号"> </el-table-column>
        <el-table-column prop="Longitude" label="经度"> </el-table-column>
        <el-table-column prop="Latitude" label="纬度"> </el-table-column>
        <el-table-column width="200" prop="PlaceCode" label="行政区划代码"> </el-table-column>
        <el-table-column prop="Place" label="位置名"> </el-table-column>
        <el-table-column width="200" prop="OrgCode" label="管辖单位代码"> </el-table-column>
        <el-table-column width="200" prop="CapDirection" label="车辆抓拍方向"> </el-table-column>
        <el-table-column prop="MonitorDirection" label="监视方向"> </el-table-column>
        <el-table-column width="200" prop="MonitorAreaDesc" label="监视区域说明"> </el-table-column>
        <el-table-column prop="IsOnline" label="是否在线">
          <template v-slot="scope">
            <span v-if="scope.row.IsOnline === 1">在线</span>
            <span v-else>离线</span>
          </template>
        </el-table-column>
        <el-table-column width="200" prop="OwnerApsID" label="所属采集系统"> </el-table-column>
        <el-table-column width="200" prop="UserId" label="用户帐号"> </el-table-column>
        <el-table-column width="200" prop="Password" label="口令"> </el-table-column>
        <!-- <el-table-column fixed="right" label="操作" width="100">
          <template slot-scope="scope">
            <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
            <el-button type="text" size="small">编辑</el-button>
          </template>
        </el-table-column> -->
      </el-table>
    </div>
    <div class="block">
      <el-pagination align="center" @current-change="handleCurrentChange" layout="prev, pager, next" :total="dataTotal"
        :page-size="8">
      </el-pagination>
    </div>
    <!-- 添加或修改用户配置对话框 -->
    <el-dialog :title="addFormTitle" :visible.sync="addFormOpen" width="800px" append-to-body>
      <el-form v-if="addFormOpen" ref="addForm" :rules="addFormRules" :model="addForm" label-width="100px">
        <div>
          <el-row>
            <el-col :span="12">
              <el-form-item label="设备ID" prop="ApeID">
                <el-input v-model="addForm.ApeID"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="名称" prop="Name">
                <el-input v-model="addForm.Name"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="型号" prop="Model">
                <el-input v-model="addForm.Model"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="IP地址" prop="IPAddr">
                <el-input v-model="addForm.IPAddr"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="端口号" prop="Port">
                <el-input v-model="addForm.Port"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="经度" prop="Longitude">
                <el-input v-model="addForm.Longitude"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="纬度" prop="Latitude">
                <el-input v-model="addForm.Latitude"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="行政区划代码" prop="PlaceCode">
                <el-input v-model="addForm.PlaceCode"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="位置名" prop="Place">
                <el-input v-model="addForm.Place"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="管辖单位代码" prop="OrgCode">
                <el-input v-model="addForm.OrgCode"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="车辆抓拍方向" prop="CapDirection">
                <el-input v-model="addForm.CapDirection"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="监视方向" prop="MonitorDirection">
                <el-input v-model="addForm.MonitorDirection"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="监视区域说明" prop="MonitorAreaDesc">
                <el-input v-model="addForm.MonitorAreaDesc"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="所属采集系统" prop="OwnerApsID">
                <el-input v-model="addForm.OwnerApsID"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="用户帐号" prop="UserId">
                <el-input v-model="addForm.UserId"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="口令" prop="Password">
                <el-input v-model="addForm.Password"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
        </div>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="addApe">确 定</el-button>
        <!-- <el-button @click="cancelAdd">取 消</el-button> -->
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { getApesPage, addApe } from "@/api/viid/data/apesData";
import { getToken } from "@/utils/auth";

export default {
  name: "apesData",
  data() {
    return {
      addFormOpen: false,
      apesDataList: [],
      addForm: {
        ApeID: "",
        Name: "",
        Model: "",
        IPAddr: "",
        IPV6Addr: "",
        Port: "",
        Longitude: "",
        Latitude: "",
        PlaceCode: "",
        Place: "",
        OrgCode: "",
        CapDirection: "",
        MonitorDirection: "",
        MonitorAreaDesc: "",
        IsOnline: "",
        OwnerApsID: "",
        UserId: "",
        Password: ""
      },
      addFormRules: {
        ApeID: [
          { required: true, message: "采集设备编号不能为空", trigger: "blur" },
          {
            min: 20,
            max: 20,
            message: "请输入正确的采集设备编号",
            trigger: "blur",
          },
        ], UserId: [
          { required: true, message: "用户账号不能为空", trigger: "blur" }
        ], Password: [
          { required: true, message: "口令不能为空", trigger: "blur" }
        ]
      },
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
  mounted() { },
  methods: {
    getApesPage() {
      var _this = this;
      console.log(_this.formData);

      getApesPage(_this.formData).then((response) => {
        console.log(response.data);
        var data = response;
        _this.dataTotal = data.total;
        console.log(data.records);
        _this.apesDataList = data.records;
      });
    },
    addApe() {
      var _this = this;
      this.addFormTitle = "新增采集设备";
      this.$refs["addForm"].validate((valid) => {
        if (valid) {
          addApe(_this.addForm).then((response) => {
            if (!response.data) {
              _this.$modal.msgSuccess("新增失败，请联系管理员");
              _this.addFormOpen = false;
              _this.getApesPage();
            } else {
              _this.$modal.msgSuccess("新增成功");
              _this.addFormOpen = false;
              _this.getApesPage();
            }
          });
        }
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

.el-image__error {}
</style>