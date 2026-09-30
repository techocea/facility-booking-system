import type { CreateFacilityDTO, Facility } from "@/features/facilities/types"
import { apiClient } from "@/lib/axios.ts"
import { useMutation, useQueryClient } from "@tanstack/react-query"

export const createFacility = (data: CreateFacilityDTO): Promise<Facility> => {
  return apiClient.post("/facilities", data)
}

export const useCreateFacility = () => {
  const queryClient = useQueryClient()

  return useMutation({
    mutationFn: createFacility,
    onSuccess: () => {
      // Automatically refresh the facility list after successful creation
      queryClient.invalidateQueries({ queryKey: ["facilities"] })
    },
  })
}