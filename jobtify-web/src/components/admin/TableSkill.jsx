import React from 'react'

const TableSkill = ({ data, onEdit, onDelete, pagination }) => {
    return (
        <div>
            <table className="border-separate border border-slate-400">
                <thead>
                    <tr>
                        <th className='border border-slate-300'>STT</th>
                        <th className='border border-slate-300'>Skill Name</th>
                        <th className='border border-slate-300'>Skill Description</th>
                        <th className='border border-slate-300'>Type</th>
                        <th className='border border-slate-300'>Edit</th>
                        <th className='border border-slate-300'>Delete</th>
                    </tr>
                </thead>
                <tbody>
                    {data.map((item, index) => (
                        <tr key={item.id}>
                            <td className='border border-slate-300'>{index + 1}</td>
                            <td className='border border-slate-300'>{item.skillName}</td>
                            <td className='border border-slate-300'>{item.skillDescription}</td>
                            <td className='border border-slate-300'>{item.type}</td>
                            <td className='border border-slate-300 bg-blue'>
                                <button onClick={() => onEdit(item)}>Edit</button>
                            </td>
                            <td className='border border-slate-300 bg-red'>
                                <button onClick={() => onDelete(item.id)}>Delete</button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    )
}

export default TableSkill