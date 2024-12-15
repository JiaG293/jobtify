
import { useState } from 'react';

const style = {
    position: 'absolute',
    top: '50%',
    left: '50%',
    transform: 'translate(-50%, -50%)',
    width: 400,
    bgcolor: 'background.paper',
    border: '2px solid #000',
    boxShadow: 24,
    pt: 2,
    px: 4,
    pb: 3,
};


export default function CreateSkillModal({ handleChangeInput, closeModal, onClick, data }) {
    return (
        <div className="fixed inset-0 bg-black bg-opacity flex items-center justify-center z-50">
            <div className="bg-gray p-6 rounded-lg shadow-lg w-96">

                <div className="flex justify-end">
                    <button
                        onClick={closeModal}
                        className="text-gray-600 hover:text-gray-900 text-lg font-bold bg-red"
                    >
                        &times;
                    </button>
                </div>

                <h3 className="text-lg font-semibold mb-4">Nhập thông tin kỹ năng</h3>
                <form className="space-y-3" onSubmit={onClick}>
                    <div>
                        <label
                            htmlFor="skillName"
                            className="block text-sm font-medium text-gray-700 mb-1"
                        >
                            Tên kỹ năng
                        </label>
                        <input
                            type="text"
                            id="skillName"
                            name='skillName'
                            value={data.skillName}
                            onChange={handleChangeInput}
                            className="border border-gray-300 rounded-md px-3 py-2 w-full"
                            required
                        />
                    </div>

                    <div>
                        <label
                            htmlFor="skillDescription"
                            className="block text-sm font-medium text-gray-700 mb-1"
                        >
                            Mô tả kỹ năng
                        </label>
                        <textarea
                            id="skillDescription"
                            name='skillDescription'
                            value={data.skillDescription}
                            onChange={handleChangeInput}
                            className="border border-gray-300 rounded-md px-3 py-2 w-full h-32"
                            placeholder="Nhập mô tả kỹ năng"
                            required
                        />
                    </div>

                    <div>
                        <label
                            htmlFor="type"
                            className="block text-sm font-medium text-gray-700 mb-1"
                        >
                            Loại kỹ năng
                        </label>
                        <select
                            id="type"
                            name='type'
                            value={data.type}
                            onChange={handleChangeInput}
                            className="border border-gray-300 rounded-md px-3 py-2 w-full"
                        >
                            <option value="">Chọn loại kỹ năng</option>
                            <option value="TECHNICAL_SKILL">Kỹ thuật</option>
                            <option value="SOFT_SKILL">Kỹ năng mềm</option>
                            <option value="UNSPECIFIC">Khác</option>
                        </select>
                    </div>

                    <div className="flex justify-end space-x-3">
                        <button
                            type="reset"
                            className="px-4 py-2 bg-gray-300 rounded hover:bg-gray-400 transition bg-red"
                        >
                            Hủy
                        </button>
                        <button
                            type="submit"
                            className="px-4 py-2 bg-green-500 text-white rounded hover:bg-green-600 transition bg-green"
                        >
                            Lưu
                        </button>
                    </div>
                </form>
            </div>
        </div>
    );
}
