import { create } from "zustand";
import api from "../api/api";
import { toast } from "react-toastify";
import Cookies from 'js-cookie'
import { useAuthStore } from "./authUser";

export const useSkillStore = create((set) => ({
    skills: null,
    dataSkill: [],
    pagination: {
        currentPage: 1,
        size: 10,
        totalElements: 0,
        totalPages: 0,
    },
    getDataSkill: async (query = {}) => {
        const { page = 0, size = 10 } = query;
        try {
            const response = await api.get("/v1/jobtify/skills", {
                params: {
                    p: page,
                    s: size,
                },
                headers: {
                    Authorization: `Bearer ${Cookies.get("token")}`,
                },
            });

            if (response.data?.result) {
                const { content, totalElements, number, totalPages } = response.data.result;
                set({
                    dataSkill: [...content],
                    pagination: {
                        currentPage: number,
                        size: size,
                        totalElements: totalElements,
                        totalPages: totalPages,
                    },
                });
            }
        } catch (error) {
            toast.error(error?.response?.data?.message || "Lỗi tải dữ liệu skill");
        }
    },

    createSkill: async (data = { type, skillName, skillDescription }) => {
        try {
            const response = await api.post("/v1/jobtify/skills", data, {
                headers: {
                    Authorization: `Bearer ${Cookies.get("token")}`,
                }
            });
            console.log(response.data)
            set((state) => ({
                skills: [...state.dataSkill, response.data.result]
            }));
            toast.success("Đã thêm một kỹ năng mới");
        } catch (error) {
            toast.error(error?.response?.data?.message || "Thêm bị lỗi thử lại sau");
            set({ isCreating: false });
        }
    },

    updateSkill: async (data) => {
        try {
            const response = await api.patch(`/v1/jobtify/skills/${data.id}`, {
                type: data.type,
                skillName: data.skillName,
                skillDescription: data.skillDescription,
            },
                {
                    headers: {
                        Authorization: `Bearer ${Cookies.get("token")}`,
                    }
                });
    
            toast.success("Cập nhật thành công");
        } catch (error) {
            toast.error(error?.response?.data?.message || "Lỗi cập nhật thử lại sau");
            set({ isUpdating: false });
        }
    },


    deleteSkill: async (id) => {
        try {
            const response = await api.delete(`/v1/jobtify/skills/${id}`, {
                headers: {
                    Authorization: `Bearer ${Cookies.get("token")}`,
                }
            });
            console.log("Response status:", response.status);
            console.log("Response data:", response.data);

            if (response.status === 200) {
                toast.success("Xóa thành công");
            } else {
                toast.error("Xóa không thành công");
            }
        } catch (error) {
            toast.error(error?.response?.data?.message || "Lỗi xóa thử lại sau");
        }
    },
}));
