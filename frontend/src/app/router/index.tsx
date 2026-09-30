import { createBrowserRouter, Navigate, RouterProvider } from "react-router-dom"
import { LoginForm } from "@/features/auth/components/LoginForm.tsx"
import { FacilityList } from "@/features/facilities/components/FacilityList.tsx"
import { MainLayout } from "@/components/layout/MainLayout.tsx"

const router = createBrowserRouter([
  {
    path: "/login",
    element: <LoginForm />,
  },{
    path:'/',
    element:<MainLayout/>,
    children:[
      {
        index: true,
        element: <Navigate to="/facilities" replace />,
      },
      {
        path: 'facilities',
        element: <FacilityList />,
      },
      // {
      //   path: 'admin',
      //   element: (
      //     <ProtectedRoute allowedRoles={['ROLE_ADMIN']}>
      //       <div>Admin Dashboard</div>
      //     </ProtectedRoute>
      //   ),
      // },
    ]
  },
  {
    path: '*',
    element: <div>404 - Page Not Found</div>,
  },
]);

export const AppRouter = () => {
  return <RouterProvider router={router} />;
};