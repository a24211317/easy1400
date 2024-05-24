<template>
  <div class="app-container">
    <div>
      <el-row :gutter="12">
        <el-form ref="elForm" :model="formData" size="medium" label-width="85px">
          <el-col :span="5">
            <el-form-item label="平台类型" prop="type">
              <el-select v-model="formData.type" placeholder="请选择">
                <el-option key="0" label="下级平台" value="0"> </el-option>
                <el-option key="1" label="上级平台" value="1"> </el-option>
                <el-option key="2" label="本级平台" value="2"> </el-option>
              </el-select>
              <!-- <el-input
                v-model="formData.type"
                clearable
                :style="{ width: '90%' }"
              >
              </el-input> -->
            </el-form-item>
          </el-col>
          <el-col :span="3">
            <el-form-item label="平台名称" prop="name">
              <el-input v-model="formData.name" clearable :style="{ width: '90%' }">
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
            addFormTitle = `新增平台`;
            addFormID = 0;
            addForm = {};
            ">新增</el-button>
          </el-col>
        </div>
      </el-row>
    </div>
    <div>
      <el-collapse v-model="activeNames" accordion @change="colChange">
        <el-collapse-item v-for="platform in viidCascadePlatformList" :key="platform.id" :title="platform.Name"
          :name="platform.id">
          <div slot="title" style="width: 100%">
            <span>{{ platform.Name }}</span>
            <div style="float: right; margin-right: 30px">
              <!--               @click.stop.prevent="openCollapse()" -->
              <el-button @click="updatePlatform(platform)">修改</el-button>
              <el-button @click="delPlatform(platform)">删除</el-button>
            </div>
          </div>
          <div>
            <el-descriptions class="margin-top" :column="2" border>
              <el-descriptions-item>
                <template slot="label"> 系统编码 </template>
                {{ platform.SystemID }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label"> 系统名称 </template>
                {{ platform.Name }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label"> 系统类型 </template>
                {{ platform.Type == 0 ? "下级平台" : platform.Type == 1 ? "上级平台" : "本级平台" }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label"> 系统IP </template>
                {{ platform.IPAddr }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label"> 系统端口 </template>
                {{ platform.Port }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label"> 注册ID </template>
                {{ platform.UserId }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label"> 密码 </template>
                {{ platform.Password }}
              </el-descriptions-item>
              <el-descriptions-item>
                <template slot="label"> 状态 </template>
                {{ platform.IsOnline == 0 ? "离线" : "在线" }}
              </el-descriptions-item>
              <!-- <el-descriptions-item>
                <template slot="label"> 开关 </template>
                {{ platform.systemID }}
              </el-descriptions-item> -->
            </el-descriptions>
          </div>
        </el-collapse-item>
      </el-collapse>
    </div>

    <!-- 添加或修改用户配置对话框 -->
    <el-dialog :title="addFormTitle" :visible.sync="addFormOpen" width="700px" append-to-body>
      <el-form v-if="addFormOpen" ref="addForm" :rules="addFormRules" :model="addForm" label-width="80px">
        <div>
          <el-form-item label="系统编码" prop="SystemID">
            <el-input v-model="addForm.SystemID"></el-input>
          </el-form-item>
          <el-form-item label="系统名称" prop="Name">
            <el-input v-model="addForm.Name"></el-input>
          </el-form-item>
          <el-form-item label="系统IP" prop="IPAddr">
            <el-input v-model="addForm.IPAddr"></el-input>
          </el-form-item>
          <el-form-item label="系统端口" prop="Port">
            <el-input v-model="addForm.Port"></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="Password">
            <el-input v-model="addForm.Password"></el-input>
          </el-form-item>
          <el-form-item label="注册ID" prop="UserId">
            <el-input v-model="addForm.UserId"></el-input>
          </el-form-item>
          <el-form-item label="平台类型" prop="Type">
            <el-select v-model="addForm.Type" style="width: 100%">
              <el-option key="0" label="下级平台" value="0"> </el-option>
              <el-option key="1" label="上级平台" value="1"> </el-option>
              <el-option key="2" label="本级平台" value="2"> </el-option>
            </el-select>
          </el-form-item>
        </div>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="addPlatformSubmit">确 定</el-button>
        <!-- <el-button @click="cancelAdd">取 消</el-button> -->
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { getViidCascadePlatforms, addViidCascadePlatform, delViidCascadePlatform, updateViidCascadePlatform, } from "@/api/viid/system/viidCascadePlatform";
import { getToken } from "@/utils/auth";

export default {
  name: "viidCascadePlatform",
  data() {
    let validateIp = (rule, value, callback) => {
      if (value == "") {
        return callback(new Error("请输入IP地址"));
      } else {
        let exp =
          /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/;
        if (!exp.test(value)) {
          callback(new Error("请输入合法的ip"));
        } else {
          callback();
        }
        callback();
      }
    };
    let validatePort = (rule, value, callback) => {
      let reg = /^(([0-9]|[1-9]\d{1,3}|[1-5]\d{4}|6[0-5]{2}[0-3][0-5]))$/;
      if (value == "") {
        callback(new Error("请输入端口号"));
      } else if (reg.test(value) == false) {
        callback(new Error("请输入合法的端口号"));
      } else {
        callback();
      }
    };
    return {
      viidCascadePlatformList: [],
      addFormOpen: false,
      clickID: "",
      activeNames: "",
      formData: {
        type: "",
        name: "",
      },
      addFormTitle: "",
      addFormID: "",

      addForm: {
        SystemID: "",
        Name: "",
        IPAddr: "",
        Port: "",
        Type: "",
        Password: "",
        id: "",
        UserId: "",
      },
      addFormRules: {
        SystemID: [
          { required: true, message: "平台ID不能为空", trigger: "blur" },
          {
            min: 20,
            max: 20,
            message: "请输入正确的平台ID",
            trigger: "blur",
          },
        ],
        Name: [
          { required: true, message: "平台名称不能为空", trigger: "blur" },
        ],
        IPAddr: [{ required: true, validator: validateIp, trigger: "blur" }],
        Port: [{ required: true, validator: validatePort, trigger: "blur" }],
        Type: [
          { required: true, message: "平台类型不能为空", trigger: "blur" },
        ],
        Password: [
          { required: true, message: "平台密码不能为空", trigger: "blur" },
        ],
        UserId: [
          { required: true, message: "注册ID不能为空", trigger: "blur" },
        ],
      },
    };
  },
  computed: {},
  watch: {},
  stopCollapse(e) {
    return e.stopPropagation();
  },
  created() {
    this.getViidCascadePlatforms();
  },
  mounted() { },
  methods: {
    getViidCascadePlatforms() {
      var _this = this;
      getViidCascadePlatforms(_this.formData).then((response) => {
        _this.viidCascadePlatformList = response.data;
        _this.activeNames = response.data[0].systemID;
      });
    },
    colChange(val) {
      this.clickID = val;
    },
    submitForm() {
      this.getViidCascadePlatforms();
    },
    addPlatformSubmit() {
      var _this = this;
      this.addFormTitle = "新增平台";
      this.$refs["addForm"].validate((valid) => {
        if (valid) {
          if (_this.addFormID == 1) {
            updateViidCascadePlatform(_this.addForm).then((response) => {
              if (response.data == true) {
                _this.$modal.msgSuccess("修改成功");
                _this.addFormOpen = false;
                _this.getViidCascadePlatforms();
              }
            });
          } else {
            addViidCascadePlatform(_this.addForm).then((response) => {
              if (response.data == true) {
                _this.$modal.msgSuccess("新增成功");
                _this.addFormOpen = false;
                _this.getViidCascadePlatforms();
              }
            });
          }
        }
      });
    },
    delPlatform(platform) {
      if (platform.Type == 2) {
        this.$modal.msgError("本级视图库禁止删除！");
      } else {
        this.$modal
          .confirm("删除不可恢复,确认删除吗？")
          .then(function () {
            return delViidCascadePlatform(platform.id);
          })
          .then(() => {
            this.getViidCascadePlatforms();
            this.$modal.msgSuccess("删除成功");
          })
          .catch(() => { });
      }
    },
    updatePlatform(platform) {
      this.addFormTitle = "修改平台";
      this.addFormID = 1;
      this.addForm.SystemID = platform.SystemID;
      this.addForm.Name = platform.Name;
      this.addForm.IPAddr = platform.IPAddr;
      this.addForm.Port = platform.Port;
      this.addForm.Type = platform.Type;
      this.addForm.Password = platform.Password;
      this.addForm.id = platform.id;
      this.addForm.UserId = platform.UserId;
      this.addFormOpen = true;
    },
  },
};
</script>
<style>
.el-collapse-item__content {
  padding: 0;
}

.el-collapse-item__header {
  padding: 2rem;
}

.el-collapse-item__header.is-active {
  background: #01a3b0;
}

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