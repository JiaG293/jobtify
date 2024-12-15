import React, { useEffect, useState } from "react";
import { Fancybox } from "@fancyapps/ui";
import { toast } from "react-toastify";
import Header from "../../components/base/Header";
import api from "../../api/api";
import Cookies from "js-cookie";
import { useJobStore } from "../../store/jobStore";
import PaginationHome from "../../components/home/PaginationHome";

const copyToClipboard = (email) => {
  navigator.clipboard.writeText(email);
  toast.info("Email đã được sao chép: " + email);
};

const openFancybox = (job) => {
  const skillsList = job?.jobSkills?.map(js => `
    <div class="mb-4">
      <h3 class="text-lg font-bold">${js.skill?.skillName || "Không có kỹ năng"}</h3>
      <p class="text-sm mb-2">${js.moreInfo || "Không có thông tin bổ sung"}</p>
    </div>
  `).join("");

  Fancybox.show([
    {
      src: `<div class="p-6">
              <h2 class="text-2xl font-bold mb-4">${job?.name || "Không có tên"}</h2>
              <p class="mb-3 text-lg"><strong>Mô tả:</strong> ${job?.description || "Không có mô tả"}</p>
              <div class="mb-4">
                <h3 class="text-lg font-bold mb-2">Thông tin kỹ năng:</h3>
                ${skillsList}
              </div>
              <div class="mb-4">
                <h3 class="text-lg font-bold mb-2">Thông tin công ty:</h3>
                <p class="text-sm text-gray-600"><strong>Công ty: </strong>${job?.company?.name || "Không có thông tin"}</p>
                <p class="text-sm text-gray-600"><strong>Email: </strong>${job?.company?.email || "Không có email"}</p>
                <button class="mt-2 bg-blue-500 hover:bg-blue-700 text-white px-4 py-2 rounded cursor-pointer" data-email="${job?.company?.email}" id="copyEmailButton">Copy Email</button>
                <p class="text-sm text-gray-600"><strong>Website: </strong><a href="${job?.company?.webURL || "#"}" class="text-blue-500 hover:underline">${job?.company?.webURL || "Không có trang web"}</a></p>
              </div>
            </div>`,
      type: "html",
    },
  ]);

  setTimeout(() => {
    const button = document.getElementById("copyEmailButton");
    if (button && button.dataset?.email) {
      button.onclick = () => copyToClipboard(button.dataset.email);
    }
  }, 100);
};

const HomePage = () => {
  const [job, setJob] = useState({

  });
  const { getDataJobs, dataJob } = useJobStore();

  useEffect(() => {
    getDataJobs();
  }, []);

  return (
    <div className="container mx-auto px-6 py-8">
      <Header />
      <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-2 gap-6 mt-4">
        {dataJob.map((job) => (
          <div
            key={job.id}
            className="bg-gray-light border rounded-lg shadow-md p-4 hover:shadow-lg transform transition-transform duration-200 ease-in-out hover:scale-105 cursor-pointer"
            onClick={() => openFancybox(job)}
          >
            <h3 className="text-lg font-semibold text-gray-800 mb-2 truncate">{job.name}</h3>
            <p className="text-sm text-gray-600 mb-2 truncate">{job.description}</p>
            <div className="text-sm text-gray-500 mb-2">
              Kỹ năng:{" "}
              {job.jobSkills?.length
                ? job.jobSkills.map((js) => js.skill?.skillName).join(", ")
                : "Không có kỹ năng"}
            </div>
            <div className="mt-2 flex justify-between items-center">
              <button
                className="bg-blue-500 hover:bg-blue-600 text-white py-1 px-2 rounded text-sm"
                onClick={(e) => {
                  e.stopPropagation();
                  copyToClipboard(job?.company?.email);
                }}
                disabled={!job?.company?.email}
              >
                Copy Email
              </button>
            </div>
          </div>
        ))}
      </div>
      <PaginationHome></PaginationHome>
    </div>
  );
};

export default HomePage;
