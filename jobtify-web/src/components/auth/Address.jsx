import React from "react";

const Address = ({ formRegister, handleChange }) => {
  return (
    <>
      <div style={{ margin: "8px 0" }}>
        <label style={{ display: "block", marginBottom: "5px" }}>Số nhà</label>
        <input
          className="bg-gray-light rounded-lg"
          type="text"
          name="number"
          value={formRegister.number}
          onChange={handleChange}
          style={{
            width: "400px",
            padding: "8px",
            boxSizing: "border-box",
          }}
        />
      </div>

      <div style={{ margin: "8px 0" }}>
        <label style={{ display: "block", marginBottom: "5px" }}>Đường</label>
        <input
          className="bg-gray-light rounded-lg"
          type="text"
          name="street"
          value={formRegister.street}
          onChange={handleChange}
          style={{
            width: "400px",
            padding: "8px",
            boxSizing: "border-box",
          }}
        />
      </div>

      <div style={{ margin: "8px 0" }}>
        <label style={{ display: "block", marginBottom: "5px" }}>Thành Phố</label>
        <input
          className="bg-gray-light rounded-lg"
          type="text"
          name="city"
          value={formRegister.city}
          onChange={handleChange}
          style={{
            width: "400px",
            padding: "8px",
            boxSizing: "border-box",
          }}
        />
      </div>

      <div style={{ margin: "8px 0" }}>
        <label style={{ display: "block", marginBottom: "5px" }}>Quốc gia</label>
        <input
          className="bg-gray-light rounded-lg"
          type="text"
          name="country"
          value={formRegister.country}
          onChange={handleChange}
          style={{
            width: "400px",
            padding: "8px",
            boxSizing: "border-box",
          }}
        />
      </div>

      <div style={{ margin: "8px 0" }}>
        <label style={{ display: "block", marginBottom: "5px" }}>ZIP code</label>
        <input
          className="bg-gray-light rounded-lg"
          type="number"
          name="zipcode"
          value={formRegister.zipcode}
          onChange={handleChange}
          style={{
            width: "400px",
            padding: "8px",
            boxSizing: "border-box",
          }}
        />
      </div>
    </>
  );
};

export default Address;
