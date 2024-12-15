import { useSkillStore } from "../../store/skillStore";

const PaginationSkill = () => {
    const { pagination, getDataSkill } = useSkillStore();
    const { currentPage, totalPages, size } = pagination;

    const handlePageClick = async (page) => {
        if (page >= 0 && page < totalPages && page !== currentPage) {
            await getDataSkill({ page, size });
        }
    };

    return (
        <div className="flex justify-center mt-4">
            <button
                onClick={() => handlePageClick(currentPage - 1)}
                className={`px-3 py-2 mx-1 border rounded ${currentPage === 0
                    ? "bg-red text-white cursor-not-allowed"
                    : "bg-green text-white hover:bg-gray-600"
                    }`}
                disabled={currentPage === 0}
            >
                Prev
            </button>

            {Array.from({ length: totalPages }).map((_, index) => (
                <button
                    key={index}
                    onClick={() => handlePageClick(index)}
                    className={`px-3 py-2 mx-1 border rounded ${index === currentPage
                        ? "bg-blue text-white hover:bg-gray-800"
                        : "bg-gray-light text-black hover:bg-gray-400"
                        }`}
                >
                    {index + 1}
                </button>
            ))}

            <button
                onClick={() => handlePageClick(currentPage + 1)}
                className={`px-3 py-2 mx-1 border rounded ${currentPage === totalPages - 1
                    ? "bg-red text-white cursor-not-allowed"
                    : "bg-green text-white hover:bg-gray-600"
                    }`}
                disabled={currentPage === totalPages - 1}
            >
                Next
            </button>
        </div>
    );
};

export default PaginationSkill;
