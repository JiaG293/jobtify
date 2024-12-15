import { useCallback, useEffect, useState } from 'react'
import TableSkill from '../../components/admin/TableSkill'
import { useSkillStore } from '../../store/skillStore';
import { ToastContainer } from 'react-toastify';
import { data, useNavigate } from 'react-router-dom';
import FormSkillModal from '../../components/admin/FormSkillModal';
import Header from '../../components/base/Header';
import PaginationSkill from '../../components/admin/PaginationSkill';

const SkillPage = () => {
    const { getDataSkill, dataSkill, createSkill, deleteSkill, updateSkill } = useSkillStore();
    const navigate = useNavigate();

    useEffect(() => {
        getDataSkill();
    }, []);

    const [showModal, setShowModal] = useState({
        edit: false,
        add: false,
    });

    const [skill, setSkill] = useState({
        skillName: "",
        skillDescription: "",
        type: "",
    });

    const handleDelete = async (id) => {
        try {
            console.log('Deleting with id:', id);
            await deleteSkill(id);
            await getDataSkill();
        } catch (error) {
            console.error("Error while deleting skill", error);
        }
    };
    const handleEdit = async (e) => {
        e.preventDefault();
        const isConfirmed = window.confirm(
            "Bạn có chắc chắn muốn cập nhật thông tin skill này không?"
        );
        if (isConfirmed) {
            await updateSkill(skill);
            await getDataSkill();
        } else {
            alert("Đã hủy thao tác cập nhật.");
        }

        setSkill({
            skillName: "",
            skillDescription: "",
            type: "",
        })
        toggleModal('edit', false)

    };

    const openModalEdit = async (data) => {
        toggleModal('edit', true)
        console.log(data)

        setSkill(data)

    };

    const handleSave = async (e) => {
        e.preventDefault();
        const isConfirmed = window.confirm(
            "Bạn có chắc chắn muốn lưu thông tin skill này không?"
        );
        if (isConfirmed) {
            await createSkill(skill);
        } else {
            alert("Đã hủy thao tác lưu.");
        }
        setSkill({
            skillName: "",
            skillDescription: "",
            type: "",
        })
    };



    const toggleModal = (type, isOpen) => {
        setShowModal((prev) => ({
            ...prev,
            [type]: isOpen,
        }));
    };

    const handleChangeInput = (e) => {
        const { name, value } = e.target;
        setSkill({
            ...skill,
            [name]: value,
        });
    };


    return (
        <div>
            <Header></Header>
            <div className="pt-16 bg-gray-100 min-h-screen">
                <button
                    type="button"
                    style={{
                        margin: "10px",
                        padding: "10px 20px",
                        backgroundColor: "green",
                        color: "white",
                        border: "none",
                        cursor: "pointer",
                    }}
                    onClick={() => toggleModal('add', true)}
                >
                    Thêm
                </button>
                <TableSkill data={dataSkill} onEdit={openModalEdit} onDelete={handleDelete}></TableSkill>
                <PaginationSkill></PaginationSkill>

                <div className="min-h-screen bg-gray-100 flex items-center justify-center">

                    {showModal.add && (
                        <FormSkillModal handleChangeInput={handleChangeInput} data={skill} closeModal={() => toggleModal('add', false)} onClick={handleSave}></FormSkillModal>
                    )}

                    {showModal.edit && (
                        <FormSkillModal handleChangeInput={handleChangeInput} data={skill} closeModal={() => toggleModal('edit', false)} onClick={handleEdit}></FormSkillModal>
                    )}


                </div>
            </div>

        </div>
    )
}

export default SkillPage    