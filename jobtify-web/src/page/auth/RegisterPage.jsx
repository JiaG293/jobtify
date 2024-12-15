import React, { useState } from "react";
import { toast, ToastContainer } from "react-toastify";
import { useAuthStore } from "../../store/authUser";
import Address from "../../components/auth/Address";
import { formatDateToDDMMYYYY } from "../../util/formatDateToDDMMYYYY";
import moment from "moment";
import 'react-toastify/dist/ReactToastify.css';
import { useNavigate } from "react-router-dom";

const RegisterPage = (props) => {
  const navigate = useNavigate();
  const [formRegister, setFormRegister] = useState({
    username: "giau1",
    password: "123",
    repassword: "123",
    dob: '2002-03-02',
    phone: "0909090909",
    email: "codenguvl@gmail.com",
    fullName: "Code Ngu Vl",

    country: "VN",
    number: "55",
    zipcode: "700000",
    street: "Lai Hung Cuong",
    city: "Ho Chi Minh",

    about: "do something",
    webURL: "codenguvl.com",
    emailInfo: "tuyendung@codenguvl.com",

    type: "candidate",
  });

  const { register, isSigningUp } = useAuthStore();

  const [show, setshow] = useState({
    showPass: false,
    showRepass: false,
    showAddress: false,
  });

  const handleRegister = async (e) => {
    e.preventDefault();
    let requestCandidate = {
      username: formRegister.username,
      password: formRegister.password,
      dob: moment(formRegister.dob, 'YYYY-MM-DD').format('DD-MM-YYYY'),
      phone: formRegister.phone,
      email: formRegister.email,
      fullName: formRegister.fullName,

      country: formRegister.country,
      number: formRegister.number,
      zipcode: formRegister.zipcode,
      street: formRegister.street,
      city: formRegister.city,

      type: formRegister.type,
    };

    if (formRegister.type === 'company') {
      requestCandidate = {
        ...requestCandidate,
        about: formRegister.about,
        webURL: formRegister.webURL,
        emailInfo: formRegister.emailInfo,
      };
    }

    try {
      register({ ...requestCandidate });
    } catch (error) {
      toast.error("Đăng ký thất bại");
    }
  };

  const togglePasswordVisibility = (name) => {
    setshow((prev) => ({
      ...prev,
      [name]: !prev[name],
    }));
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormRegister({
      ...formRegister,
      [name]: value,
    });
  };

  return (
    <div style={{ maxWidth: "60ch", minWidth: "40ch", margin: "0 auto", padding: "20px" }}>
      <h3 className="text-3xl">Welcome To The Hell</h3>
      <form onSubmit={handleRegister} style={{ display: "flex", flexDirection: "column" }}>
        {!show.showAddress ? (
          <>
            <label>Loại tài khoản</label>
            <select
              className="bg-gray-light rounded-lg"
              name="type"
              value={formRegister.type}
              onChange={handleChange}
              style={{ marginBottom: "10px", padding: "8px" }}
            >
              <option value="candidate">Candidate</option>
              <option value="company">Company</option>
            </select>

            <label>Họ và tên</label>
            <input
              className="bg-gray-light rounded-lg"
              type="text"
              name="fullName"
              value={formRegister.fullName}
              onChange={handleChange}
              style={{ marginBottom: "10px", padding: "8px" }}
            />

            {formRegister.type === "candidate" ? (
              <>
                <label>Ngày sinh</label>
                <input
                  className="bg-gray-light rounded-lg"
                  type="date"
                  name="dob"
                  value={formRegister.dob}
                  onChange={handleChange}
                  style={{ marginBottom: "10px", padding: "8px" }}
                />
              </>
            ) : (
              <>
                <label>Địa chỉ web công ty</label>
                <input
                  className="bg-gray-light rounded-lg"
                  type="text"
                  name="webURL"
                  value={formRegister.webURL}
                  onChange={handleChange}
                  style={{ marginBottom: "10px", padding: "8px" }}
                />

                <label>Thông tin thêm</label>
                <input
                  className="bg-gray-light rounded-lg"
                  type="text"
                  name="about"
                  value={formRegister.about}
                  onChange={handleChange}
                  style={{ marginBottom: "10px", padding: "8px" }}
                />

                <label>Email tuyển dụng</label>
                <input
                  className="bg-gray-light rounded-lg"
                  type="email"
                  name="emailInfo"
                  value={formRegister.emailInfo}
                  onChange={handleChange}
                  style={{ marginBottom: "10px", padding: "8px" }}
                />
              </>
            )}

            <label>Email</label>
            <input
              className="bg-gray-light rounded-lg"
              type="email"
              name="email"
              value={formRegister.email}
              onChange={handleChange}
              style={{ marginBottom: "10px", padding: "8px" }}
            />

            <label>Số điện thoại</label>
            <input
              className="bg-gray-light rounded-lg"
              type="text"
              name="phone"
              value={formRegister.phone}
              onChange={handleChange}
              style={{ marginBottom: "10px", padding: "8px" }}
            />

            <label>Tài khoản</label>
            <input
              className="bg-gray-light rounded-lg"
              type="text"
              name="username"
              value={formRegister.username}
              onChange={handleChange}
              style={{ marginBottom: "10px", padding: "8px" }}
            />

            <label>Mật khẩu</label>
            <input
              className="bg-gray-light rounded-lg"
              type={show.showPass ? "text" : "password"}
              name="password"
              value={formRegister.password}
              onChange={handleChange}
              style={{ marginBottom: "10px", padding: "8px" }}
            />
            <button
              type="button"
              onClick={() => togglePasswordVisibility("showPass")}
              style={{ marginBottom: "10px", padding: "8px" }}
            >
              {show.showPass ? "Ẩn mật khẩu" : "Hiển thị mật khẩu"}
            </button>

            <label>Nhập lại mật khẩu</label>
            <input
              className="bg-gray-light rounded-lg"
              type={show.showRepass ? "text" : "password"}
              name="repassword"
              value={formRegister.repassword}
              onChange={handleChange}
              style={{ marginBottom: "10px", padding: "8px" }}
            />
            <button
              className="bg-gray-light-light rounded-lg"
              type="button"
              onClick={() => togglePasswordVisibility("showRepass")}
              style={{ marginBottom: "10px", padding: "8px" }}
            >
              {show.showRepass ? "Ẩn mật khẩu" : "Hiển thị mật khẩu"}
            </button>


          </>
        ) : <Address formRegister={formRegister} handleChange={handleChange}></Address>}


        <div style={{ display: "flex", flexDirection: "column", justifyContent: "center" }}>
          <button
            type="button"
            onClick={() => togglePasswordVisibility("showAddress")}
            style={{
              margin: "10px",
              padding: "10px 20px",
              backgroundColor: `${!show.showAddress ? "green" : "#bf2424"}`,
              color: "white",
              border: "none",
              cursor: "pointer",
            }}
          >
            {!show.showAddress ? "Tiếp theo" : "Quay lại"}
          </button>
          <button
            disabled={!show.showAddress}
            type="submit"
            style={{
              margin: "10px",
              padding: "10px 20px",
              backgroundColor: `${show.showAddress ? "green" : "grey"}`,
              color: "white",
              border: "none",
              cursor: "pointer",
            }}
          >
            Đăng ký
          </button>
          {
            show.showAddress ? <button
              type="button"
              onClick={() => navigate('/signin')}
              style={{
                margin: "10px",
                padding: "10px 20px",
                backgroundColor: "#4183c4",
                color: "white",
                border: "none",
                cursor: "pointer",
              }}
            >Chuyển sang đăng nhập</button> : null
          }
        </div>

      </form>
      <ToastContainer />
    </div>
  );
};

export default RegisterPage;
